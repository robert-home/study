package pl.rbudner.study.codility;

public class DecimalReprZip {

    public static void main(String[] args) {
        System.out.println(new DecimalReprZip().solution(555, 123));
    }

    public int solution(int A, int B) {
        String stringA = Integer.toString(A);
        String stringB = Integer.toString(B);
        int lenght = Math.max(stringA.length(), stringB.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            result.append(charAt(stringA, i));
            result.append(charAt(stringB, i));
        }
        long num = Long.valueOf(String.valueOf(result.toString()));
        return (num > 100000000) ? -1 : (int) num;
    }

    String charAt(String src, int i) {
        return (i < src.length()) ? src.substring(i, i + 1) : "";
    }
}
