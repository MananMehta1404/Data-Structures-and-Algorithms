import java.util.*;

public class FindEventualSafeStates_BFS {

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

    public static List<Integer> bfs(List<List<Integer>> graph, int n) {
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for (int it : graph.get(i)) {
                reverseGraph.get(it).add(i);
                indegree[i]++;
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for (int it : reverseGraph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {6, 7}, {8, 1}, {8, 9}, {9, 10}, {10, 8}, {11, 9}};
        int n = 12;

        List<List<Integer>> graph = createGraph(n, edges);

        List<Integer> safeNodes = bfs(graph, n);
        System.out.println(safeNodes);
    }
}
