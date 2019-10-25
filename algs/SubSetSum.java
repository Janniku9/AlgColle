package AlgsFromScript;

public class SubSetSum {
    public static Boolean [][] DP (int[] A, int s) {
        Boolean [][] DP = new Boolean [A.length+1][s+1];

        for (int i = 0; i < DP[0].length; i++) {
           DP[0][i] = false;
        }

        DP[0][0] = true;

        for (int i = 1; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                if ( j - A[i-1] >= 0)
                    DP[i][j] = DP[i-1][j] || DP[i-1][j-A[i-1]];
                else
                    DP[i][j] = DP[i-1][j];
            }
        }

        return DP;
    }


    public static boolean isReachable (int[] A, int s) {
        Boolean[][] DP = DP(A, s);
        return DP[DP.length-1][DP[0].length-1];
    }

    public static int[] subSet (int[] A, int s) {
        Boolean[][]DP = DP(A, s);

        int i = DP.length-1, j = DP[0].length-1;

        int length = 0;

        while (i>0 && j>0) {
            if (DP[i][j] == DP[i-1][j])
                i--;
            else if (DP[i][j] = DP[i-1][j-A[i-1]]){
                i--; j -= A[i];
                length++;
            }
        }

        i = DP.length-1; j = DP[0].length-1;

        int [] res = new int [length];
        while (i>0 && j>0) {
            if (DP[i][j] == DP[i-1][j])
                i--;
            else if (DP[i][j] = DP[i-1][j-A[i-1]]){
                i--; j -= A[i]; length--;
                res [length] = A[i];
            }
        }

        return res;
    }
}
