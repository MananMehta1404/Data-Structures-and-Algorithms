import java.util.*;

public class Prims_Algo {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int MST_Cost(int V, List<List<Pair>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);

        int[] vis = new int[V];
        pq.add(new Pair(0, 0));

        int sum = 0;

        while (pq.size() > 0) {
            int wt = pq.peek().weight;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).weight;
                int adjNode = adj.get(node).get(i).node;
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edW));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int sum = MST_Cost(V, adj);
        System.out.println("The cost of MST is: " + sum);
    }
}
