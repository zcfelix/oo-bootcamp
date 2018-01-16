import org.junit.Test;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EvaluationTest {

    @Test
    public void should_evaluate_eagerly() {
        Evaluation.eagerEvaluator(Evaluation.evaluate(1), Evaluation.evaluate(2));
    }

    @Test
    public void should_evaluate_lazy() {
        Evaluation.lazyEvaluator(() -> Evaluation.evaluate(1), () -> Evaluation.evaluate(2));
    }

}