public class DFSTraversal {

    static int visited[] = {0,0,0,0,0,0,0};
    static int graph [][] = {
        {0,1,1,1,0,0,0},
        {1,0,1,0,0,0,0},
        {1,1,0,1,1,0,0},
        {1,0,1,0,1,0,0},
        {0,0,1,1,0,1,1},
        {0,0,0,0,1,0,0}, 
        {0,0,0,0,1,0,0} 
    };

    public static void DFS(int start){
        System.out.print(start + " ");
        visited[start] = 1;
        for(int i = 0; i < 7; i++){
            if(graph[start][i] == 1 && visited[i] == 0) DFS(i);
        }
    }
    public static void main(String[] args) {
        DFS(3);
    }
}
