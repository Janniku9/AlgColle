package AlgsFromScript;

public class LGT {
    public static int LGTLength (String string1, String string2) {
        int [][] DP = LGTDP(string1, string2);

        return DP[DP.length-1][DP[0].length-1];
    }

    static int[][] LGTDP (String string1, String string2) {
        String [] s1 = string1.split("");
        String [] s2 = string2.split("");

        int [][] DP = new int [s1.length+1][s2.length+1];

        for (int i = 0; i < DP.length; i++) {
            DP[i][0] = 0;
        }

        for (int i = 0; i < DP[0].length; i++) {
            DP[0][i] = 0;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j < DP[0].length; j++) {
                if (!s1[i-1].equals(s2[j-1])) {
                    DP[i][j] = Math.max(DP[i-1][j-1] ,Math.max(DP[i-1][j], DP[i][j-1]));
                } else {
                    DP[i][j] = Math.max(DP[i-1][j-1] + 1, Math.max(DP[i-1][j], DP[i][j-1]));
                }
            }
        }

        return DP;

    }

    public static String LGT (String string1, String string2) {
        int[][] DP = LGTDP(string1, string2);
        String lgt = "";

        String [] s1 = string1.split("");
        String [] s2 = string2.split("");

        int i = DP.length-1, j = DP[0].length-1;
        while (i>0 && j>0) {
            if (DP [i][j] == DP[i-1][j])
                i--;
            else if (DP[i][j] == DP[i][j-1])
                j--;
            else if (DP[i][j] == DP [i-1][j-1] + 1 && s1[i-1].equals(s2[j-1])){
                j--; i--;
                lgt = s1[i] + lgt;
            } else if (DP[i][j] == DP[i-1][j-1]) {
                j--; i--;
            }
        }
        return lgt;
    }
}
