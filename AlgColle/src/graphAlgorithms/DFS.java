package graphAlgorithms;
import dataStructures.*;

public class DFS {
    public static int[] depthSearch (Graph graph, int v) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.n];
        boolean[] popped = new boolean[graph.n];

        Stack<Integer> sort = new Stack<Integer>();
        int[][] list = graph.calculateList(graph.ADJ);

        stack.push(v);
        while (!stack.isEmpty()) {
            int w = stack.top();
            if (!visited[w]) {
                visited[w] = true;
                for (int i = 0; i < list[w].length; i++) {
                    stack.push(list[w][i]);
                }
            } else {
                if (!popped[w]) {
                    sort.push(w);
                    popped[w] = true;
                }
                stack.pop();
            }
        }

        int[] res = new int[sort.length];
        int z = 0;
        while (!sort.isEmpty()) {
            res[z] = sort.pop();
            z++;
        }

        return res;
    }
}
