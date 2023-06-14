import java.util.*;

public class NoOfOperations_To_MakeNetworkConnected {

    public static int countOp(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int m = edges.length;
        
        int cntExtras = 0;
        for (int i = 0; i < m ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntExtras++;
            } 
            else {
                ds.unionBySize(u, v);
            }
        }

        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) cntC++;
        }

        int ans = cntC - 1;
        if (cntExtras >= ans) return ans;
        return -1;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        int ans = countOp(V, edges);
        System.out.println("The number of operations needed: " + ans);
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
