import java.util.*;

public class Min_MultiplicationsToReachEnd {

    static class Pair {
        int num;
        int steps;

        Pair(int num, int steps) {
            this.num = num;
            this.steps = steps;
        }
    }

    public static int minMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        int[] dist = new int[100000];
        for(int i = 0; i < dist.length; i++) {
            dist[i] = (int)(1e9);
        }
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek().num;
            int steps = q.peek().steps;
            q.remove();

            for(int i: arr) {
                int num = (node * i) % 100000;
                if (num == end) {
                    return steps + 1;
                } 
                if(dist[num] > steps + 1) {
                    dist[num] = steps + 1;
                    q.add(new Pair(num, steps + 1));
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 84;

        System.out.println(minMultiplications(arr, start, end));
    }
}