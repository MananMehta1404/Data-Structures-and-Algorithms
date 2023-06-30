import java.util.*;;

public class Combination_Sum_II {

    public static void findCombinations(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> l1){
        // Base Case
        if(target == 0) {
            result.add(new ArrayList<>(l1));
            return;
        }

        // We will loop from idx to n - 1
        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;

            l1.add(candidates[i]);
            findCombinations(candidates, i + 1, target - candidates[i], result, l1);
            l1.remove(l1.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, result, new ArrayList<>());
        System.out.println(result);
    }
}
