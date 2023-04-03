package Graph.Traversing_Graph;

import java.util.*;

// BFS for connected graph using Adjacency Matrix.
public class BFS_AM {

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

    public static int[] bfs_AM(int[][] graph, int n, int start) {
        boolean[] visited = new boolean[n];
        int[] bfs = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int i = 0;

        while (!q.isEmpty()) {
            int val = q.remove();
            bfs[i++] = val;

            for (int j = 0; j < n; j++) {
                if (graph[val][j] == 1 && visited[j] == false) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {

        int n = 9;
        int[][] edges = {{0, 1}, {0, 5}, {1, 2}, {1, 3}, {3, 4}, {4, 7}, {5, 6}, {5, 8}, {6, 7}};

        int[][] graph = createGraph(n, edges);

        int[] bfs = bfs_AM(graph, n, 0);

        // Printing the BFS Traversal
        for (int i = 0; i < n; i++) {
            System.out.print(bfs[i] + " ");
        }
    }
}
