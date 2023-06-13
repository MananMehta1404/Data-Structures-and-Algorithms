import java.util.*;

public class Number_Of_Provinces {

    public static int number_Of_Provinces(int[][] adjMatrix, int V) {
        DisjointSet ds = new DisjointSet(V);
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(adjMatrix[i][j] == 1)  {
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < V; i++) {
            if(ds.findUPar(i) == i) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {5, 6}};

        int[][] adjMat = new int[V][V];
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }

        int ans = number_Of_Provinces(adjMat, V);
        System.out.println("The number of provinces are: " + ans);
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

