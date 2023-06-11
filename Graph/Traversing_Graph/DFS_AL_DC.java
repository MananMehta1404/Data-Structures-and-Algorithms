import java.util.*;

// DFS for disconnected graph using Adjacency List.
// Time Complexity -> O(V + E) where V -> No. of Vertices and E -> No. of edges.
public class DFS_AL_DC {

    static class Edge{
        int src;
        int des;

        Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }

    public static List<List<Edge>> createGraph(int n, int[][] edges){

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];

            graph.get(src).add(new Edge(src, des));
            graph.get(des).add(new Edge(des, src));
        }

        return graph;
    }

    public static void dfs_AL_DC(List<List<Edge>> graph, int start, boolean visited[], List<Integer> dfs){
        dfs.add(start);
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            Edge e = graph.get(start).get(i);
            if(visited[e.des] == false) dfs_AL_DC(graph, e.des, visited, dfs);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0, 1}, {1, 4}, {1, 5}, {2, 3}, {2, 6}, {3, 7}, {6, 7}};

        List<List<Edge>> graph = createGraph(n, edges);

        /*
                     0
                   /  
                  1     2 --- 3
                 /  \   |     |
                4    5  6 --- 7 
         */

        List<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                dfs_AL_DC(graph, i, visited, dfs);
            }
        }

        // Print DFS
        System.out.println(dfs);
    }
}
