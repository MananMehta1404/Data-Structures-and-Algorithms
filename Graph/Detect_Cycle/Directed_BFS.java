import java.util.*;

public class Directed_BFS {

    public static List<List<Integer>> createGraph(int n, int[][] edges){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];

            graph.get(src).add(des);
        }

        return graph;
    }

    public static void main(String[] args) {
        // int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {3, 7}, {4, 5}, {5, 6}, {7, 5}, {8, 2}, {8, 9}, {9, 10}, {10, 8}};
        int[][] edges = {{3, 1}, {2, 3}, {4, 1}, {4, 0}, {5, 2}, {5, 0}};
        int n = 6;

        List<List<Integer>> graph = createGraph(n, edges);

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int des : graph.get(node)){
                indegree[des]--;
                if(indegree[des] == 0){
                    queue.add(des);
                }
            }
        }

        if(count == n){
            System.out.println("No Cycle");
        }
        else{
            System.out.println("Cycle");
        }
    }
}
