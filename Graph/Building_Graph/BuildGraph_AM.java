package Graph.Building_Graph;

// Creating a graph using Adjacency Matrix.
public class BuildGraph_AM {

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

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};

        int[][] graph = createGraph(n, edges);

        // Printing the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
