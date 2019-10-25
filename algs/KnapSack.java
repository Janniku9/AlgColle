package AlgsFromScript;

public class KnapSack {
    public static int [][] DP (int [] V, int []W, int w) {
        int [][] DP = new int [V.length+1][w+1];

        for (int i = 0; i < DP.length; i++) {
            DP[i][0] = 0;
        }

        for (int i = 0; i < DP[0].length; i++) {
            DP[0][i] = 0;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {
                if (j - W[i-1] >= 0)
                    DP [i][j] = Math.max(DP[i-1][j], DP[i-1][j-W[i-1]] + V[i-1]);
                else
                    DP[i][j] = DP[i-1][j];
            }
        }

        return DP;
    }

    public static int [][] unlimitedDP (int [] V, int [] W, int w) {
        int [][] DP = new int [V.length+1][w+1];
        for (int i = 0; i < DP.length; i++) {
            DP[i][0] = 0;
        }

        for (int i = 0; i < DP[0].length; i++) {
            DP[0][i] = 0;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {
                if (j - W[i-1] >= 0)
                    DP [i][j] = Math.max(Math.max(DP[i-1][j], DP[i-1][j-W[i-1]] + V[i-1]), DP[i][j-W[i-1]] + V[i-1]);
                else
                    DP[i][j] = DP[i-1][j];
            }
        }

        return DP;
    }
}
