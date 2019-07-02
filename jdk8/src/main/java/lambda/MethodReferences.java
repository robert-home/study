package lambda;

import java.util.function.Predicate;

public class MethodReferences {

    public void simpleMethodReference() {
        Predicate<Apple> applePredicate0 = new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.isHavy();
            }
        };
        Predicate<Apple> applePredicate1 = (Apple apple) -> apple.isHavy();
        Predicate<Apple> applePredicate2 = Apple::isHavy;
    }

}
