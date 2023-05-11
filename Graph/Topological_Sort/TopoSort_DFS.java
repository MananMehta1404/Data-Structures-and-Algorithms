import java.util.*;

public class TopoSort_DFS {

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

    public static void dfs(List<List<Edge>> graph, int src, int[] visited, Stack<Integer> stack){
        visited[src] = 1;

        for(Edge e : graph.get(src)){
            if(visited[e.des] == 0){
                dfs(graph, e.des, visited, stack);
            }
        }

        stack.push(src);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 1}, {2, 3}, {4, 1}, {4, 0}, {5, 2}, {5, 0}};

        List<List<Edge>> graph = createGraph(n, edges);

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
