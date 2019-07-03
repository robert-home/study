package pl.rbudner.study.codility;

import java.util.HashSet;
import java.util.Set;

class Point3D {
    public int x;
    public int y;
    public int z;
}

public class CentralSphereCoverageSize {

    public static void main(String[] args) {
        Point3D[] A = new Point3D[6];

        for (int i = 0; i < 6; i++) A[i] = new Point3D();

        A[0].x =  0;  A[0].y =  5;  A[0].z =  4;
        A[1].x =  0;  A[1].y =  0;  A[1].z = -3;
        A[2].x = -2;  A[2].y =  1;  A[2].z = -6;
        A[3].x =  1;  A[3].y = -2;  A[3].z =  2;
        A[4].x =  1;  A[4].y =  1;  A[4].z =  1;
        A[5].x =  4;  A[5].y = -4;  A[5].z =  3;

        System.out.println(new CentralSphereCoverageSize().solution(A));

    }
    public int solution(Point3D[] A) {
        Set<Long> resultSet = new HashSet<>();
        for (Point3D p : A) {
            resultSet.add(new Long(p.x*p.x + p.y*p.y + p.z*p.z));
        }
        System.out.println(resultSet);
        return resultSet.size();
    }

}

