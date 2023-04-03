package Graph.Traversing_Graph;

import java.util.*;

public class DFS_AM {

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
    
    public static void dfs_AM(int[][] graph, int n, int start, boolean[] visited, List<Integer> dfs) {
        dfs.add(start);
        visited[start] = true;

        for(int i = 0; i < n; i++){
            if(graph[start][i] == 1 && visited[i] == false) dfs_AM(graph, n, i, visited, dfs);
        }
    }
    
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}, {3, 7}, {6, 7}};

        int[][] graph = createGraph(n, edges);

        /*
                     0
                   /   \
                  1     2 --- 3
                 /  \   |     |
                4    5  6 --- 7 
         */

        List<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[n];
        dfs_AM(graph, n, 0, visited, dfs);

        // Printing the DFS Traversal
        System.out.println(dfs);
    }
}
