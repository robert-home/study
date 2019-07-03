package pl.rbudner.study.codility;

public class DigitlessPassword {

    public static void main(String[] args) {
        System.out.println(new DigitlessPassword().solution("a0Ba"));
    }

    public int solution(String S) {
        int maxLen = -1;
        String[] splitted = S.replaceAll("[A-Z]", "#").split("[0-9]");
        for(int i = 0; i < splitted.length; i++) {
            if (splitted[i].length() > 0 && splitted[i].contains("#") && splitted[i].length() > maxLen) maxLen = splitted[i].length();
        }
        return maxLen;
    }
}
