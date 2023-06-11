import java.util.*;

// BFS for connected graph using Adjacency List. 
// Time Complexity -> O(V + E) where V -> No. of Vertices and E -> No. of edges.
public class BFS_AL_C{

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

    public static List<Integer> bfs_AL_C(List<List<Edge>> graph, int n, int start){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.add(start);

        List<Integer> bfs = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.remove();

            if(visited[curr] == false){
                bfs.add(curr);
                visited[curr] = true;

                for(int i = 0; i < graph.get(curr).size(); i++){
                    Edge e = graph.get(curr).get(i);
                    q.add(e.des);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        int n = 9;

        int[][] edges = {{0, 1}, {0, 5}, {1, 2}, {1, 3}, {3, 4}, {4, 7}, {5, 6}, {5, 8}, {6, 7}};

        List<List<Edge>> graph = createGraph(n, edges);

        /*
                       0
                     /   \
                    1     5
                   / \   / \
                  2   3 6   8
                       \ \ 
                        4-7
        */

        List<Integer> bfs = bfs_AL_C(graph, n, 0);
        System.out.println(bfs);
    }
}