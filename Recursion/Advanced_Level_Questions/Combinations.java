package Recursion.Advanced_Level_Questions;
import java.util.*;

public class Combinations {
    public static void findCombinations(int i, int n, int k, List<List<Integer>> result, List<Integer> l1){
        // Base Case
        if(k == 0){
            result.add(new ArrayList<>(l1));
            return;
        }
        // Second Base Case
        if(i > n) return;

        // We have two options -> Either we pick the element or we don't pick
        // First Case
        l1.add(i);
        findCombinations(i + 1, n, k - 1, result, l1);
        l1.remove(l1.size() - 1);
        // Second Case
        findCombinations(i + 1, n, k, result, l1);
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1, n, k, result, new ArrayList<>());
        System.out.println(result);
    }
}
