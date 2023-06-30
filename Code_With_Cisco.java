import java.util.*;

public class Code_With_Cisco {
    public static int maxPoints(List<Integer> list, int n, boolean isJames) {
        if (n == 2) return Math.max(list.get(0), list.get(n - 1));

        int left = 0;
        int right = 0;

        if(isJames) {
            left = list.get(0) + maxPoints(list.subList(1, n), n - 1, !isJames);
            right = list.get(n - 1) + maxPoints(list.subList(0, n - 1), n - 1, !isJames);
            return Math.max(left, right);
        } 
        else {
            left = maxPoints(list.subList(1, n), n - 1, !isJames);
            right = maxPoints(list.subList(0, n - 1), n - 1, !isJames);
            return Math.min(left, right);
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(11);
        list.add(2);
        list.add(10);
        System.out.println(list);

        int n = list.size();
        int ans = maxPoints(list, n, true);

        System.out.println("Maximum points James can earn are: " + ans);
    }
}