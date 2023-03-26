package Recursion.Advanced_Level_Questions;
import java.util.*;

public class Combination_Sum_I {

    public static void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> result, List<Integer> l1){
        // Base Case
        if(idx == candidates.length){
            if(target == 0) {
                result.add(new ArrayList<>(l1));
            }
            return;
        }

        // If we want to pick that element
        if(candidates[idx] <= target){
            l1.add(candidates[idx]);
            // We call the function with the same index again and a reduced target
            findCombinations(idx, candidates, target - candidates[idx], result, l1);
            // After coming back from the above recursion we remove the last added element.
            l1.remove(l1.size() - 1);
        }
        // If we don't want to pick that element
        findCombinations(idx + 1, candidates, target, result, l1);
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>());
        System.out.println(result);
    }
}
