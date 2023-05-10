import java.util.*;

public class AllPaths {

    // Creating a Edge class to store the source, destination.
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

    // Time Complexity -> O(V^V) where V is No. of Vertices
    public static void printAllPaths(List<List<Edge>> graph, int curr, boolean visited[], String path, int tar){
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph.get(curr).size(); i++){
            Edge e = graph.get(curr).get(i);
            if(!visited[e.des]){
                visited[curr] = true;
                printAllPaths(graph, e.des, visited, path + e.des + "->", tar);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5}, {5, 6}};

        List<List<Edge>> graph = createGraph(n, edges);

        /*

          1 ---- 3
         /       | \
        0        |   5 -- 6
         \       | /
          2 ---- 4
         
        */

        int src = 0, tar = 5;
        boolean[] visited = new boolean[n];
        printAllPaths(graph, src, visited, "0 -> ", tar);
        System.out.println();
    }
}
