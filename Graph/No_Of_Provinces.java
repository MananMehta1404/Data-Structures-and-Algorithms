package Graph;

import java.util.*;

public class No_Of_Provinces {

    static class Edge{
        int src;
        int des;

        Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }

    public static void dfs_AL_DC(List<List<Edge>> graph, int start, boolean visited[]){
        visited[start] = true;

        for(int i = 0; i < graph.get(start).size(); i++){
            Edge e = graph.get(start).get(i);
            if(visited[e.des] == false) dfs_AL_DC(graph, e.des, visited);
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = isConnected.length;

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        // Create Adjacency List from Adjacency Matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    graph.get(i).add(new Edge(i, j));
                    graph.get(j).add(new Edge(j, i));
                }
            }
        }  

        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                count++;
                dfs_AL_DC(graph, i, visited);
            }
        }

        System.out.println("No. of provinces is: " + count);

    }
}
