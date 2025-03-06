package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenQuadricResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(3, 7, x -> Math.pow(x, 2) + 5 * x + 3);
        List<Double> expected = Arrays.asList(27D, 39D, 53D, 69D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenIndicativeResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(1024D, 4096D, 16384D);
        assertThat(result).containsAll(expected);
    }
}