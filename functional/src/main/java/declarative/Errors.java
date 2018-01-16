package declarative;

import java.text.MessageFormat;

public enum Errors {
    FIELD_NOT_EXIST("field [{0}] not exist"),
    NOT_MATCH_PATTERN("field [{0}] not match pattern"),
    FIELD_IS_NOT_TYPE("field [{0}] is not [{1}]");

    protected String errorMessageFormat;

    Errors(String errorMessageFormat) {
        this.errorMessageFormat = errorMessageFormat;
    }

    public String formatErrorMessage(String... errorParams) {
        MessageFormat messageFormat = new MessageFormat(errorMessageFormat);
        String format = messageFormat.format(errorParams);
        return format;
    }
}
