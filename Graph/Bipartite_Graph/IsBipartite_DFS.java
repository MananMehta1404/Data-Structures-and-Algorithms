import java.util.*;

public class IsBipartite_DFS {

    public static int[][] createGraph(int n, int[][] edges) {

        int[][] graph = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];

            graph[src][des] = 1;
            graph[des][src] = 1;
        }

        return graph;
    }

    // DFS
    public static boolean check(int start, int[][] graph, int[] color) {
        for (int i = 0; i < graph[start].length; i++) {
            if(graph[start][i] == 0) continue;
            
            int neighbour = i;

            // If the neighbour is not coloured, then colour it with the opposite color of the node.
            if (color[neighbour] == -1) {
                color[neighbour] = 1 - color[start];
                boolean ans = check(neighbour, graph, color);
                if (ans == false)
                    return false;
            } 
            // If the neighbour is coloured and the color of the neighbour is same as the color of the node, then the graph is not bipartite.
            else if (color[neighbour] == color[start]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};

        /*
                 4
                /|\
               0 | 3
                \|/|
                 1 |
                  \|
                   2
         */

        int[][] graph = createGraph(n, edges);

        int[] color = new int[n];
        Arrays.fill(color, -1);

        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                ans = check(i, graph, color);
                if(ans == false) break;
            }
        }

        System.out.println("The graph is Bipartite: " + ans);
    }
}
