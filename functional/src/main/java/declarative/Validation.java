package declarative;

import java.util.*;

import static declarative.Errors.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;


public final class Validation {

    @FunctionalInterface
    interface Validator {
        List<String> validate(Map<String, Object> json);
    }

    public static List<String> validate(final Map<String, Object> json, final Validator... validators) {
        return Arrays
                .stream(validators)
                .map(validator -> validator.validate(json))
                .flatMap(Collection::stream)
                .collect(toList());
    }

    public static Validator requiredField(final String field) {
        return info -> notExistFieldErrorMsg(info, field).map(Collections::singletonList).orElse(emptyList());
    }

    public static Validator requiredFields(final String... fields) {
        return info -> Arrays.stream(fields)
                .map(field -> notExistFieldErrorMsg(info, field))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    public static Validator withPattern(final String field, final String pattern) {
        return info -> hasNestedAttr(info, field) ?
                (notMatchPatternErrorMsg(info, field, pattern)
                        .map(Collections::singletonList)
                        .orElse(emptyList())) : singletonList(FIELD_NOT_EXIST.formatErrorMessage(field));
    }

    public static Validator withFieldType(String field, Class clazz) {
        return info -> {
            if (hasNestedAttr(info, field)) {
                if (clazz.isInstance(getNestedAttr(info, field))) {
                    return emptyList();
                } else {
                    return singletonList(FIELD_IS_NOT_TYPE.formatErrorMessage(field, clazz.getSimpleName()));
                }
            }
            return singletonList(FIELD_NOT_EXIST.formatErrorMessage(field));
        };
    }

    private static Optional<String> notMatchPatternErrorMsg(Map<String, Object> info, final String field, final String pattern) {
        final Object value = getNestedAttr(info, field);
        if (value instanceof String) {
            return value.toString().matches(pattern) ? Optional.empty() : Optional.of(NOT_MATCH_PATTERN.formatErrorMessage(field));
        }
        return Optional.of(FIELD_IS_NOT_TYPE.formatErrorMessage(field, "String"));
    }

    private static Optional<String> notExistFieldErrorMsg(final Map<String, Object> info, final String field) {
        return hasNestedAttr(info, field) ? Optional.empty() : Optional.of(FIELD_NOT_EXIST.formatErrorMessage(field));
    }

    private static boolean hasNestedAttr(final Map<String, Object> info, final String field) {
        final String[] nestedAttrs = field.split("\\.");
        Map<String, Object> curMap = info;
        for (int i = 0; i < nestedAttrs.length; ++i) {
            final String curAttr = nestedAttrs[i];
            if (i + 1 == nestedAttrs.length) {
                return curMap.containsKey(curAttr);
            }
            Object object = curMap.get(curAttr);
            if (object instanceof Map) {
                curMap = (Map) object;
            } else {
                return false;
            }
        }
        return true;
    }

    private static Object getNestedAttr(final Map<String, Object> info, final String field) {
        final String[] nestedAttrs = field.split("\\.");
        Map<String, Object> curMap = info;
        for (int i = 0; i < nestedAttrs.length - 1; ++i) {
            curMap = (Map) curMap.get(nestedAttrs[i]);
        }
        return curMap.get(nestedAttrs[nestedAttrs.length - 1]);
    }

}
