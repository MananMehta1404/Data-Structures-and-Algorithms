package Graph;

import java.util.*;

public class FindEventualSafeStates_DFS {
    
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
        }

        return graph;
    }

    public static boolean dfs(List<List<Edge>> graph, int src, int[] visited, int[] pathVisited, int[] check){
        visited[src] = 1;
        pathVisited[src] = 1;
        check[src] = 0;

        for(int i = 0; i < graph.get(src).size(); i++){
            Edge e = graph.get(src).get(i);
            if(visited[e.des] == 0){
                if(dfs(graph, e.des, visited, pathVisited, check)){
                    check[src] = 0;
                    return true;
                }
            }
            else if(pathVisited[e.des] == 1){
                check[src] = 0;
                return true;
            }
        }

        check[src] = 1;
        pathVisited[src] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {6, 7}, {8, 1}, {8, 9}, {9, 10}, {10, 8}, {11, 9}};
        int n = 12;

        List<List<Edge>> graph = createGraph(n, edges);

        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        int[] check = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(graph, i, visited, pathVisited, check);
            }
        }

        int countSafe = 0;
        for(int i = 0; i < n; i++){
            if(check[i] == 1) countSafe += 1;
        }

        System.out.println("Number of safe states: " + countSafe);
    }
}