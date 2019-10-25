package dataStructures;
import main.Util;

public class Graph {
    public int n;
    public int [][] ADJ;
    int [][] List;

    public Graph (int n) {
        this.n = n;
        int [][] ADJ = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ADJ[i][j] = Util.randomInt(2);
            }
        }

        this.ADJ = ADJ;
    }

    public Graph (int [][] adj) {
        this.n = adj.length;
        this.ADJ = adj;
    }

    public int[][] calculateList (int[][] ADJ){
        int[][] res = new int[ADJ.length][];

        for (int i = 0; i < ADJ.length; i++) {
            int z = 0;
            for (int j = 0; j < ADJ.length; j++) {
                if (ADJ[i][j] == 1)
                    z++;
            }

            res[i] = new int[z];
            z = 0;

            for (int j = 0; j < ADJ.length; j++) {
                if (ADJ[i][j] == 1) {
                    res[i][z] = j;
                    z++;
                }
            }
        }
        return res;
    }

}
