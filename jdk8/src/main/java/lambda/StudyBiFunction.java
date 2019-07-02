package lambda;

import java.util.*;
import java.util.function.UnaryOperator;

public class StudyBiFunction {

    UnaryOperator<Integer> unaryOpt = i -> i * i;

    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        map.merge("USD", 13L, Long::sum);
        map.merge("USD", 13L, StudyBiFunction::sum);
        System.out.println(map.get("USD"));

        List<String> list = Arrays.asList("koko", "euro", "spoko");
        System.out.println(list.stream().sorted());
    }

    private static long sum(long a, long b) {
        return a + b;
    }

    private static double divide(long a, int b) {
        return a / b;
    }
}
