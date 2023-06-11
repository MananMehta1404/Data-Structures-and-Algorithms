import java.util.*;

// Creating a Graph using Adjcency List.
public class BuildGraph_AL {

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

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {3, 4}};

        List<List<Edge>> graph = createGraph(n, edges);

        // Printing the edges of the node 2
        int node = 1;
        for(int i = 0; i < graph.get(node).size(); i++){
            Edge e = graph.get(node).get(i);
            System.out.println(e.src + " -> " + e.des);
        }
    }
}
