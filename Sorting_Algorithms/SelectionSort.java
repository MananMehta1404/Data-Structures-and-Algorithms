public class SelectionSort {

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }   

    public static void main(String[] args) {
        int arr[] = {7, 8, 3, 1, 2, -1, 23, -50, 5};
        int n = arr.length;

        // Selection Sort -> Sorting the elements in the ascending order.
        // Time Complexity -> O(n^2) (n = length of array)
        for(int i = 0; i < n - 1; i++){
            int smallestIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[smallestIndex]) smallestIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

        printArray(arr);
    }
}
