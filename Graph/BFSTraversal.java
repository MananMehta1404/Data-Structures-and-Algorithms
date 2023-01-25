package Graph;

import java.util.*;

public class BFSTraversal {

    public static void main(String[] args) {
        int[] visited = {0,0,0,0,0,0,0};
        int[][] graph1 = {
            {0,1,1,1,0,0,0},
            {1,0,1,0,0,0,0},
            {1,1,0,1,1,0,0},
            {1,0,1,0,1,0,0},
            {0,0,1,1,0,1,1},
            {0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0},
        };

        Queue<Integer> q1 = new LinkedList<>();
        int start = 1;
        System.out.print(start + " ");
        visited[start] = 1;
        q1.add(start);

        while(!q1.isEmpty()){
            int val = q1.remove();
            for(int i = 0; i < 7; i++){
                if(graph1[val][i] == 1 && visited[i] == 0){
                    System.out.print(i + " ");
                    visited[i] = 1;
                    q1.add(i);
                } 
            }
        }
    }
}
