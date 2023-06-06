package Graph.Detect_Cycle;

import java.util.*;

public class Directed_DFS {

    public static List<List<Integer>> createGraph(int n, int[][] Integers){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < Integers.length; i++){
            int src = Integers[i][0];
            int des = Integers[i][1];

            graph.get(src).add(des);
        }

        return graph;
    }

    public static boolean dfs(List<List<Integer>> graph, int src, int[] visited, int[] pathVisited){
        visited[src] = 1;
        pathVisited[src] = 1;

        for(int i = 0; i < graph.get(src).size(); i++){
            int des = graph.get(src).get(i);
            if(visited[des] == 0){
                if(dfs(graph, des, visited, pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[des] == 1){
                return true;
            }
        }

        pathVisited[src] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] Integers = {{1, 2}, {2, 3}, {3, 4}, {3, 7}, {4, 5}, {5, 6}, {7, 5}, {8, 2}, {8, 9}, {9, 10}, {10, 8}};
        int n = 11;

        List<List<Integer>> graph = createGraph(n, Integers);

        int[] visited = new int[n];
        int[] pathVisited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                if(dfs(graph, i, visited, pathVisited)){
                    System.out.println("Cycle is present at node: " + i);
                    break;
                }
            }
        }
    }
}
