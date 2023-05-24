// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

import java.util.*;

// Time Complexity: O(n^2 * log(m)) where m is a variable.
// Space Complexity: O(n) + O(m) where m is the number of unique triplets.
public class Three_Sum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            HashSet<Integer> temp = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int third = -(nums[i] + nums[j]);
                if(temp.contains(third)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    set.add(list);
                }
                temp.add(nums[j]);
            }

        }

        result.addAll(set);

        System.out.println(result);
    }
}