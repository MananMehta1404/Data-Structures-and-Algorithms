import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals_Algo {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int _src, int _dest, int _wt) {
            this.src = _src; this.dest = _dest; this.weight = _wt;
        }

        // Comparator function used for sorting edgesbased on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Pair {
        int src, des, wt;

        Pair(int _src, int _des, int _wt) {
            this.src = _src; this.des = _des; this.wt = _wt;
        }
    }

    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    public static int spanningTree(int V, List<List<Pair>> adj) {
        List<Edge> edges = new ArrayList<Edge>();
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).des;
                int wt = adj.get(i).get(j).wt;
                int node = i;
                Edge temp = new Edge(node, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjointSet ds = new DisjointSet(V);
        // M log M
        Collections.sort(edges);
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
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

            adj.get(u).add(new Pair(u, v, w));
            adj.get(v).add(new Pair(v, u, w));
        }

        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
