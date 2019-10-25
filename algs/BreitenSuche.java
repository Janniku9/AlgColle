package AlgsFromScript;

public class BreitenSuche {
    public static int[] BFS (Graph g, int v) {
        int [][] list = g.calculateList(g.ADJ);
        boolean [] visited = new boolean[list.length];
        boolean [] found = new boolean[list.length];
        int[] res = new int[visited.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(v);
        res[v] = 0;
        found[v] = true;
        int z = 0;

        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            if (!visited[w]) {
                visited[w] = true;
                for (int i = 0; i < list[w].length; i++) {
                    if (!found[list[w][i]]) {
                        queue.enqueue(list[w][i]);
                        res[list[w][i]] = res[w] + 1;
                        found[list[w][i]] = true;
                    }
                }
            }
        }

        return res;
    }
}
