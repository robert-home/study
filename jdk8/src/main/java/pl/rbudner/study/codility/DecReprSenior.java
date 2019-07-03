package pl.rbudner.study.codility;

import java.util.Arrays;

public class DecReprSenior {

    public static void main(String[] args) {
        System.out.println(new DecReprSenior().solution(214));
    }

    public int solution(int N) {
        String num = Integer.toString(N);
        char[] digits = num.toCharArray();
        Arrays.sort(digits);
        char[] sorted = new char[digits.length];
        for(int i = 0; i < sorted.length; i++) sorted[i] = digits[digits.length - i - 1];
        long result = Long.valueOf(String.valueOf(sorted));
        return (result > 100000000) ? -1 : (int) result;
    }

}
