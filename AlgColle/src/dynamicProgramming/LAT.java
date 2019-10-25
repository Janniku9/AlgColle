package dynamicProgramming;
import main.Util;

public class LAT {
    public static int LATSquared (int [] A) {
        int [] DP = new int [A.length];

        DP[0] = 1;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j])
                    DP[i] = Math.max(DP[i] , DP[j] + 1);
            }
        }

        return Util.findMax(DP);
    }

    public static int[] getLATSquared (int [] A) {
        int [] DP = new int [A.length];

        DP[0] = 1;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j])
                    DP[i] = Math.max(DP[i] , DP[j] + 1);
            }
        }

        int[] Lat = new int[Util.findMax(DP)];
        int current = Lat.length;
        for (int i = DP.length-1; i >= 0; i--) {
            if (DP[i] == current) {
                Lat[current-1] = A[i];
                current--;
            }
        }

        return Lat;
    }

    public static int LATBinary (int [] A) {
        return 0;
    }
}
