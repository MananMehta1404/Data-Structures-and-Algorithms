import java.util.*;

public class UWG_BFS {

    // This is the function to create the graph.
    public static List<List<Integer>> createGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];

            graph.get(src).add(des);
            graph.get(des).add(src);
        }

        return graph;
    }

    public static List<Integer> shortestPath(int n, int m, int src, List<List<Integer>> graph) {

        //A dist array of size n initialised with a large number to indicate that initially all the nodes are untraversed. 
        int dist[] = new int[n];
        for(int i = 0;i < n; i++) dist[i] = (int)1e9;
        dist[src] = 0; 

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src); 
        while(!q.isEmpty()) {
            int node = q.peek(); 
            q.remove(); 
            for(int des : graph.get(node)) {
                if(dist[node] + 1 < dist[des]) {
                    dist[des] = 1 + dist[node]; 
                    q.add(des); 
                }
            }
        }

        // Updated shortest distances are stored in the resultant list ‘ans’. Unreachable nodes are marked as -1. 
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dist[i] == 1e9) ans.add(-1);
            else ans.add(dist[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 9;
        int m = 10;
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        List<List<Integer>> graph = createGraph(n, edges);

        List<Integer> result = shortestPath(n, m, 0, graph);

        System.out.println(result);
    }
}
