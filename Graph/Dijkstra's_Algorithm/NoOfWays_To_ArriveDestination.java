import java.util.*;

public class NoOfWays_To_ArriveDestination {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int noOfWays(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road: roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
            ways[i] = 0;
        }

        dist[0] = 0;    
        ways[0] = 1;

        int mod = (int)(1e9 + 7);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().dist;
            pq.remove();

            for(Pair p: adj.get(node)) {
                int adjNode = p.node;
                int edw = p.dist;

                if(dis + edw < dist[adjNode]) {
                    dist[adjNode] = dis + edw;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
                else if(dis + edw == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] roads = {{0, 1, 1}, {0, 2, 2}, {0, 3, 1}, {0, 4, 2}, {1, 5, 2}, {2, 5, 1}, {3, 5, 2}, {3, 7, 3}, {3, 6, 2}, {4, 6, 1}, {5, 8, 1}, {7, 8, 1}, {6, 8, 1}};

        System.out.println(noOfWays(n, roads));
    }
}
