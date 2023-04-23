public class QuickSort {

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Now we have to place the pivot
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;  // i here basically represents the pivot index. Now all the elements before pivot are smaller than pivot and all the elements after the pivot are greater than pivot. So this is the fixed position of the pivot in the sorted array.
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Time Complexity in worst case is -> O(n^2) : This is the case when the pivot is always the largest or smallest element of the array. Basically when the array is already sorted in either ascending or descending order.
    // Time Complexity in average case is -> O(nlogn)
    
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 2, 5, 8};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        // Print the sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
