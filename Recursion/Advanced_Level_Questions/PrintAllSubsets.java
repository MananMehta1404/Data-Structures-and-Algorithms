package Recursion.Advanced_Level_Questions;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {
    public static void printSubset(List<Integer> subset){
        for(int i = 0; i < subset.size(); i++){
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, List<Integer> subset){
        if(n == 0){
            printSubset(subset);
            return;
        }

        subset.add(n);
        findSubsets(n - 1, subset);
        subset.remove(subset.size() - 1);
        findSubsets(n - 1, subset);
    }
    public static void main(String[] args) {
        int n = 3;
        findSubsets(n, new ArrayList<>());
    }
    
}
