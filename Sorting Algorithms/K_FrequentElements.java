// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

import java.util.*;
public class K_FrequentElements {

    public static int findMax(Hashtable<Integer, Integer> ht){
        int max = 0;
        int result = 0;
        for(Integer key: ht.keySet()){
            if(max < ht.get(key)){
                max = ht.get(key);
                result = key;
            }
        }
        return result;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> l1 = new ArrayList<>();
        
        Hashtable<Integer, Integer> ht1 = new Hashtable<>();
        for(int i = 0; i < nums.length; i++){
            if(ht1.containsKey(nums[i])){
                ht1.put(nums[i], ht1.get(nums[i]) + 1);
                continue;
            }
            ht1.put(nums[i], 1);
        }

        int j = 0;
        while(j < k){
            int freq = findMax(ht1);
            l1.add(freq);
            ht1.remove(freq);
            j += 1;
        }

        return l1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}