import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PairTest {

    @Test
    public void should_create_limit_pair() {
        Pair<String, Long> maximum = new Pair<>("maximum", 1024L);
        System.out.println(maximum);
    }

    @Test
    public void should_create_pair_with_wildcard() {
        Pair<?, ?> limit = new Pair<>("maximum", 1024L);
        System.out.println(limit);
    }

    @Test
    public void should_raw_type_equals_after_type_erasure() {
        System.out.println(new ArrayList<String>().getClass());
        System.out.println(new ArrayList<Long>().getClass());
    }

    @Test(expected = ClassCastException.class)
    public void should_cast_success_although_it_should_not() {
        m1();
    }

    @Test(expected = ArrayStoreException.class)
    public void should_not_create_array_with_concrete_type() {
        Object[] objArr = new String[10];
        objArr[0] = "123";
        objArr[1] = 1L;
    }

    @Test
    public void should_fail() {
        Pair<?, ?>[] pairArr = new Pair[10];
        pairArr[0] = new Pair<>(1, 2);
        pairArr[1] = new Pair<>("s", "b");
        Pair<?, ?> ss = pairArr[1];
        System.out.println(pairArr[0]);
        System.out.println(pairArr[1]);
//        Pair<Integer, Integer>[] intPairArr = new Pair<Integer, Integer>[10];
    }

    private void m1() {
        List<Date> list = new ArrayList<>();
        list.add(new Date());
        m2(list);
    }

    private void m2(Object arg) {
        List<String> list = (List<String>) arg;   // unchecked warning
        m3(list);
    }

    private void m3(List<String> list) {
        String s = list.get(0);
    }
}