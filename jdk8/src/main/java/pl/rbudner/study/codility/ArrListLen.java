package pl.rbudner.study.codility;

public class ArrListLen {

    public static void main(String[] args) {
        int[] array = {1, 4, -1, 3, 2};
        System.out.println(new ArrListLen().solution(array));
    }

    public int solution(int[] A) {
        int i = 0, j = 1;
        while (A[i] > -1) {
            i = A[i];
            j++;
        }
        return j;
    }
}
