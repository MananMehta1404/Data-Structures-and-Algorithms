import java.util.*;

public class BellmanFord_Algo {

    public static List<List<Integer>> createGraph(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        int idx = 0;
        for(int[] edge: edges) {
            for(int i: edge) {
                graph.get(idx).add(i);
            }
            idx++;
        }

        return graph;
    }

    public static int[] bellmanFord(List<List<Integer>> graph, int V, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[S] = 0;

        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> it : graph) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative cycle
        for (List<Integer> it : graph) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        int S = 0;

        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {2, 3, 6}, {4, 2, 2}, {4, 5, 4}, {5, 3, 1}};

        List<List<Integer>> graph = createGraph(V, edges);

        System.out.println(graph);

        int[] dist = bellmanFord(graph, V, S);

        for(int i = 0; i < V; i++) {
            System.out.println("Distance of " + i + " from source: " + dist[i]);
        }
    }
}
