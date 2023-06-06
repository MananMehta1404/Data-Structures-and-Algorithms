import java.util.*;

public class TopoSort_DFS {

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

    public static void dfs(List<List<Integer>> graph, int src, int[] visited, Stack<Integer> stack){
        visited[src] = 1;

        for(int des : graph.get(src)){
            if(visited[des] == 0){
                dfs(graph, des, visited, stack);
            }
        }

        stack.push(src);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 1}, {2, 3}, {4, 1}, {4, 0}, {5, 2}, {5, 0}};

        List<List<Integer>> graph = createGraph(n, edges);

        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
