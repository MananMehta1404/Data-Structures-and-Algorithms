import java.util.*;

public class Print_ShortestPath {

    static class Pair{
        int distance;
        int node;

        public Pair(int distance, int node){
            this.node = node;
            this.distance = distance;
        }
    }

    static class Edge{
        int src;
        int des;
        int weight;

        public Edge(int src, int des, int weight){
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    public static List<List<Edge>> createGraph(int n, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            int weight = edge[2];

            graph.get(src).add(new Edge(src, des, weight));
            graph.get(des).add(new Edge(des, src, weight));
        }

        return graph;
    }

    public static List<Integer> dijkstra(int n, List<List<Edge>> graph, int src) {
        // Create a priority queue for storing the nodes as a pair {dist, node } where dist is the distance from source to the node.  
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        
        int[] parent = new int[n];
        // Initialising parent array with node itself to indicate the nodes are unvisited initially.
        for(int i = 0; i < n; i++) parent[i] = i;
        
        int[] dist = new int[n];
        // Initialising dist array with a large number to indicate the nodes are unvisited initially.
        // This array contains distance from source to the nodes.
        for(int i = 0; i < n; i++) dist[i] = (int)(1e9); 
        
        // Source initialised with dist = 0.
        dist[src] = 0;
        pq.add(new Pair(0, src)); 
        
        // Now, pop the minimum distance node first from the min-heap and traverse for all its adjacent nodes.
        while(pq.size() != 0) {
            int dis = pq.peek().distance; 
            int node = pq.peek().node; 
            pq.remove(); 
            
            // Check for all adjacent nodes of the popped out element whether the prev dist is larger than current or not.
            for(int i = 0; i < graph.get(node).size(); i++) {
                Edge e = graph.get(node).get(i);
                int adjNode = e.des;
                int edgeWeight = e.weight;
                
                // If current distance is smaller, push it into the queue.
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight; 
                    pq.add(new Pair(dist[adjNode], adjNode)); 
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        if(dist[n-1] == (int)(1e9)) {
            return result;
        }
        int node = n-1;
        while(parent[node] != node) {
            result.add(node);
            node = parent[node];
        }
        result.add(node);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}, {3, 4, 9}};

        List<List<Edge>> graph = createGraph(n, edges);

        List<Integer> result = dijkstra(n, graph, 0);

        System.out.println(result);
    }
}
