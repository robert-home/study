package pl.rbudner.study.jdk8.lambda;

@FunctionalInterface
public interface StudyFunctionalInterface {

    boolean CONST = true;

    boolean study(String text);

    default boolean getStudy(String s) {
        return study(s);
    }

    default int size(String s) {
        return  s.length();
    }

    static boolean getConst() {
        return CONST;
    }

}
