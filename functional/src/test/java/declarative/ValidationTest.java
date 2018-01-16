package declarative;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static declarative.Validation.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationTest {

    private Map<String, Object> json;

    @Before
    public void setUp() {
        json = new HashMap<String, Object>() {{
            put("employee_id", "a444187");
            put("id", "zy");
            put("from_date", "2018-01-11");
            put("to_date", "2018-06-30");
            put("attributes", new HashMap<String, Object>(){{
                put("int", 1);
                put("double", 2.2);
                put("name", new HashMap<String, Object>(){{
                    put("first", "felix");
                }});
            }});
        }};
    }

    @Test
    public void should_return_empty_error_list_when_has_required_field() {
        final List<String> ret = validate(json, requiredField("id"));
        assertThat(ret.size(), is(0));
    }

    @Test
    public void should_return_error_list_when_does_not_have_required_field() {
        final List<String> ret = validate(json, requiredField("not_has_field"));
        assertThat(ret.size(), is(1));
        assertThat(ret.get(0), containsString("not_has_field"));
    }

    @Test
    public void should_return_empty_error_list_when_has_required_fields() {
        final List<String> ret = validate(json, requiredFields("employee_id", "id", "from_date", "to_date"));
        assertThat(ret.size(), is(0));
    }

    @Test
    public void should_return_error_list_when_does_not_have_required_fields() {
        final List<String> ret = validate(json, requiredFields("employee_id", "id", "not_has_1", "not_has_2"));
        assertThat(ret.size(), is(2));
        assertThat(ret.get(0), containsString("not_has_1"));
        assertThat(ret.get(1), containsString("not_has_2"));
    }

    @Test
    public void should_return_empty_error_list_when_has_required_nested_field() {
        final List<String> ret = validate(json, requiredFields("attributes.name.first"));
        assertThat(ret.size(), is(0));
    }

    @Test
    public void should_return_error_list_when_does_not_have_required_nested_field() {
        final List<String> ret = validate(json, requiredFields("attributes.name.not_have"));
        assertThat(ret.size(), is(1));
        assertThat(ret.get(0), containsString("attributes.name.not_have"));
    }

    @Test
    public void should_return_empty_error_list_when_field_matches_pattern() {
        final List<String> ret = validate(json, withPattern("employee_id", "^[a-z][1-9]+"));
        assertThat(ret.size(), is(0));
    }

    @Test
    public void should_return_error_list_when_field_not_matches_pattern() {
        final List<String> ret = validate(json, withPattern("employee_id", "not_match_pattern"));
        assertThat(ret.size(), is(1));
        assertThat(ret.get(0), containsString("employee_id"));
    }

    @Test
    public void should_return_empty_error_list_when_field_meet_required_type() {
        final List<String> ret = validate(json,
                withFieldType("attributes", Map.class),
                withFieldType("attributes.int", Integer.class),
                withFieldType("attributes.double", Double.class));
        assertThat(ret.size(), is(0));
    }

    @Test
    public void should_return_error_list_when_field_not_meet_required_type() {
        final List<String> ret = validate(json,
                withFieldType("attributes", ArrayList.class),
                withFieldType("attributes.int", Double.class),
                withFieldType("attributes.double", Integer.class));
        assertThat(ret.size(), is(3));
        assertThat(ret.get(0), containsString("attributes"));
        assertThat(ret.get(1), containsString("attributes.int"));
        assertThat(ret.get(2), containsString("attributes.double"));
    }
}
