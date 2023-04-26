// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

import java.util.*;
public class MajorityElement_II {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            float count = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count += 1;
                }
            }
            if(count > nums.length/3.0){
                int flag = 0;
                for(int k = 0; k < l1.size(); k++){
                    if(l1.get(k) == nums[i]){
                        flag = 1;
                    }
                }
                if(flag == 0){
                    l1.add(nums[i]);
                }
            }
        }
        return l1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElement(nums));
    }
}