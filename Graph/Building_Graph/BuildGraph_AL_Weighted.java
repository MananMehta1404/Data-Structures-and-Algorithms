import java.util.*;

// Creating a Graph using Adjcency List with Weighted Edges.
public class BuildGraph_AL_Weighted {
    
    // Creating a Edge class to store the source, destination and weight of the edge.
    static class Edge{
        int src;
        int des;
        int wt;

        Edge(int s, int d, int w){
            this.src = s;
            this.des = d;
            this.wt = w;
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
            int weight = edges[i][2];

            graph.get(src).add(new Edge(src, des, weight));
            graph.get(des).add(new Edge(des, src, weight));
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 10}, {0, 4, 20}, {1, 2, 30}, {1, 3, 40}, {1, 4, 50}, {2, 3, 60}, {3, 4, 70}};

        List<List<Edge>> graph = createGraph(n, edges);

        // Printing the edges of the node 2
        int node = 2;
        for(int i = 0; i < graph.get(node).size(); i++){
            Edge e = graph.get(node).get(i);
            System.out.println(e.src + " -> " + e.des + " , " + e.wt);
        }
    }
}
