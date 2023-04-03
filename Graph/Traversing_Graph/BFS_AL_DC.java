package Graph.Traversing_Graph;

import java.util.*;

// BFS for disconnected graph using Adjacency List.
// Time Complexity -> O(V + E) where V -> No. of Vertices and E -> No. of edges.
public class BFS_AL_DC {

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

    public static void bfs_AL_DC(List<List<Edge>> graph, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i = 0; i < graph.get(curr).size(); i++){
                    Edge e = graph.get(curr).get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        List<List<Edge>> graph = createGraph(n, edges);

        /*

        0 --- 1 --- 2
        3 --- 4
         
        */

        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                bfs_AL_DC(graph, visited, i);
            }
        }
        System.out.println();
    }
}
