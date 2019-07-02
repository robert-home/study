package lambda;

import java.util.function.*;

@SuppressWarnings("UnusedAssignment")
class Main {

    private int instanceVariable = 8;

    public static void main(String[] args) {
        StudyFunctionalInterface sfi = text -> text != null && text.length() > 0;
        Main main = new Main();
        main.testNotAnnotatedFunctionalInterface();
        main.testBuiltinFunctionalInterfaces();
    }

    private NotAnnotatedFunctionalInterface testNotAnnotatedFunctionalInterface() {
        return () -> Short.MAX_VALUE;
    }

    private void testBuiltinFunctionalInterfaces() {
        int localMethodVariable = 9;

        Predicate<String> stringPredicate = (String string) -> string != null;
        stringPredicate = stringPredicate.and((String string) -> string.length() > 0);
        assert stringPredicate.test("NON-NULL");

        Supplier<Main> mainSupplier = () -> this;
        assert this.equals(mainSupplier.get());

        Function<String, Integer> function = s -> s.length();

        BiFunction<String, Object[], String> biFunction = (String format, Object[] args) -> String.format(format, args);
        Integer i = biFunction.andThen(function).apply("%s%s", new Object[] {"1", "2"});
        assert i == 2;

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        assert intBinaryOperator.applyAsInt(1, 2) == 3;

        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.andThen(stringConsumer).accept("TEST");

        Predicate<?> predicate = (Number s) -> {
            instanceVariable += 8;
            int localInt = localMethodVariable * instanceVariable;
            // localMethodVariable = 3; // effectively final variable
            return s.intValue() == localInt;
        };
    }


    private void testLambdaExpressionThrowingException() {
        testLambda(() -> 8);

        NotAnnotatedFunctionalInterface nafi = () -> 8.8;
        //Object o = (p) -> 8.8;
        Object o1 = nafi;
    }

    private void testLambda(NotAnnotatedFunctionalInterface lambda) {
        lambda.execute();
    }
}
