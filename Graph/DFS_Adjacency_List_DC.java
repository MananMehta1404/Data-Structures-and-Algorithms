package Graph;

import java.util.*;

// DFS for disconnected graph using Adjacency List.
// Time Complexity -> O(V + E) where V -> No. of Vertices and E -> No. of edges.
public class DFS_Adjacency_List_DC {

    static class Edge{
        int src;
        int des;

        Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visited[e.des] == false) dfs(graph, e.des, visited);
        }
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        /*

        0 --- 1 --- 2
        3 --- 4
         
        */

        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                dfs(graph, i, visited);
            }
        }
        System.out.println();
    }
}
