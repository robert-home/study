package pl.rbudner.study.jdk8.lambda;

@SuppressWarnings("UnusedAssignment")
public class Main {

    static void main(String[] args) {
        StudyFunctionalInterface sfi = text -> text != null && text.length() > 0;
    }

}
