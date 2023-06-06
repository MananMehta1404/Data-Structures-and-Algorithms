import java.util.*;

public class CourseSchedule_II {

    public static List<List<Integer>> createGraph(int n, int[][] edges){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int src = edges[i][1];
            int des = edges[i][0];

            graph.get(src).add(des);
        }

        return graph;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {{3, 1}, {2, 3}, {4, 1}, {4, 0}, {5, 2}, {5, 0}, {1, 2}};
        
        int n = numCourses;
        List<List<Integer>> graph = createGraph(n, prerequisites);

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

        int[] topo = new int[n];
        int idx = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[idx++] = node;

            for(int des : graph.get(node)){
                indegree[des]--;
                if(indegree[des] == 0){
                    queue.add(des);
                }
            }
        }

        if(idx == n) System.out.println("True");
        else System.out.println("False");;
    }
}
