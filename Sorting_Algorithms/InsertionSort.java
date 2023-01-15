public class InsertionSort {

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }   

    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 2, -1, 23, -50, 5};
        int n = arr.length;

        // Insertion Sort -> Sorting the elements in the ascending order.
        // Time Complexity -> O(n^2) (n = length of array)
        for(int i = 1; i < n; i++){
            int temp = arr[i];

            // Better Approach
            int j = i - 1;
            while(j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            // Placement of the element in the sorted array
            arr[j + 1] = temp;

            // My approach
            // int place = i;
            // for(int j = i - 1; j >= 0; j--){
            //     if(temp < arr[j]) {
            //         arr[place] = arr[j];
            //         place = j;
            //     } 
            // }
            // Placement of the element in the sorted array
            // arr[place] = temp;
        }

        printArray(arr);
    }
}
