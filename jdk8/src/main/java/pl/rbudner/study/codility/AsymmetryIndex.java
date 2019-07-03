package pl.rbudner.study.codility;

public class AsymmetryIndex {

    public static void main(String[] args) {
        System.out.println(new AsymmetryIndex().solution(5, new int[] {5,5,1,7,2,3,5,5}));
    }

    public int solution(int X, int[] A) {
        int eq = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = (X == A[i]) ? 1 : 0;
            eq += A[i];
        }
        int neq = A.length - eq;
        eq = 0;
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] == 1) ++eq;
            else --neq;
            if (eq == neq) return i + 1;
        }
        return 0;
    }

}
