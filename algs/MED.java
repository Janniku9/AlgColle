package AlgsFromScript;

public class MED {
    public static int[][] MEDDP (String string1, String string2) {
        String[] s1 = string1.split("");
        String[] s2 = string2.split("");
        
        int[][] DP = new int [s1.length+1][s2.length+1];

        for (int i = 0; i < DP.length; i++) {
            DP[i][0] = i;
        }

        for (int i = 0; i < DP[0].length; i++) {
            DP[0][i] = i;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {
                if (s1[i-1].equals(s2[j-1]))
                    DP[i][j] = Math.min(DP[i-1][j] + 1, Math.min(DP[i][j-1] + 1, DP[i-1][j-1]));
                else
                    DP[i][j] = Math.min(DP[i-1][j] + 1, Math.min(DP[i][j-1] + 1, DP[i-1][j-1] + 1));
            }
        }

        return DP;
    }

    public static int MEDLength (String s1, String s2) {
        int [][] DP = MEDDP(s1, s2);

        return DP[DP.length-1][DP[0].length-1];
    }
}
