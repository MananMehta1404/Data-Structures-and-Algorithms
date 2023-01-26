package Graph;

import java.util.*;

// DFS for connected graph using Adjacency List. 
// Time Complexity -> O(V + E) where V -> No. of Vertices and E -> No. of edges.
public class DFS_Adjacency_List_C {

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
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
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
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        /*

          1 ---- 3
         /       | \
        0        |   5 -- 6
         \       | /
          2 ---- 4
         
        */

        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited);
        System.out.println();
    }
}
