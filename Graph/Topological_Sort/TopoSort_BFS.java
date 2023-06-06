import java.util.*;

public class TopoSort_BFS {

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
        int n = 6;
        int[][] edges = {{3, 1}, {2, 3}, {4, 1}, {4, 0}, {5, 2}, {5, 0}};

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

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int des : graph.get(node)){
                indegree[des]--;
                if(indegree[des] == 0){
                    queue.add(des);
                }
            }
        }

        System.out.println(result);
    }
}
