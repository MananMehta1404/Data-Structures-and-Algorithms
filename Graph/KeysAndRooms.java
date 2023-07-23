import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = 1;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int i = 0; i < rooms.get(node).size(); i++) {
                int newNode = rooms.get(node).get(i);
                if(vis[newNode] == 0) {
                    q.add(newNode);
                    vis[newNode] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> room0 = new LinkedList<>();
        room0.add(1);
        List<Integer> room1 = new LinkedList<>();
        room1.add(2);
        List<Integer> room2 = new LinkedList<>();
        room2.add(3);
        List<Integer> room3 = new LinkedList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        System.out.println(canVisitAllRooms(rooms));
    }
}
