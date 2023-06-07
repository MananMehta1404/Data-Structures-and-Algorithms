import java.util.*;

public class DAWG_TopoSort {

    static class Pair {
        int des, wt;

        Pair(int _des, int _wt) {
            this.des = _des;
            this.wt = _wt;
        }
    }

    //This is the function to implement Topological sort. 
    public static void topoSort(int node, List<List<Pair>> graph, int vis[], Stack<Integer> st) {

        vis[node] = 1;
        for (int i = 0; i < graph.get(node).size(); i++) {
            int des = graph.get(node).get(i).des;
            if (vis[des] == 0) {
                topoSort(des, graph, vis, st);
            }
        }
        st.add(node);
    }

    // This is the function to create the graph.
    public static List<List<Pair>> createGraph(int n, int[][] edges) {
        
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];
            
            graph.get(src).add(new Pair(des, wt));
        }
        
        return graph;
    }

    //This is the function to find the shortest path from source to all other nodes.
    public static List<Integer> shortestPath(int n, int m, List<List<Pair>> graph, int src) {
        int vis[] = new int[n];
        
        //Now, we perform topo sort using DFS technique and store the result in the stack st.
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topoSort(i, graph, vis, st);
            }
        }

        //Further, we declare a array ‘dist’ in which we update the value of the node's distance from the source vertex after relaxation of a particular node.
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }

        dist[src] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int des = graph.get(node).get(i).des;
                int wt = graph.get(node).get(i).wt;

                if (dist[node] + wt < dist[des]) {
                    dist[des] = wt + dist[node];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) result.add(-1);
            else result.add(dist[i]);
        }

        return result;
    }
    
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int n = 6;
        int m = 7;

        List<List<Pair>> graph = createGraph(n, edges);

        List<Integer> result = shortestPath(n, m, graph, 0);

        System.out.println(result);
    }
}
