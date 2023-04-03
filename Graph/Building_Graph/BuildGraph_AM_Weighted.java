package Graph.Building_Graph;

// Creating a graph using Adjacency Matrix with Weighted Edges.
public class BuildGraph_AM_Weighted {

    public static int[][] createGraph(int n, int[][] edges) {

        int[][] graph = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            int weight = edges[i][2];

            graph[src][des] = weight;
            graph[des][src] = weight;
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 10}, {0, 4, 20}, {1, 2, 30}, {1, 3, 40}, {1, 4, 50}, {2, 3, 60}, {3, 4, 70}};

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
