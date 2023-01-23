public class MergeSort {

    // This function is used to perform the main task of the merge sort i.e. merging the sorted arrays.
    public static void conquer(int[] arr, int si, int mid, int ei){
        int merged[] = new int[ei - si + 1];  // New array after merging
        int idx1 = si;  // Sorted array's(before mid and including mid) first index 
        int idx2 = mid + 1;  // Sorted array's(after mid) first index
        int x = 0;  // Starting index of mergred array

        // We will compare the elements of first and second sorted array and put them in the merged array accordingly while either of them reaches the end.
        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x++] = arr[idx1++];
            }
            else{
                merged[x++] = arr[idx2++];
            }
        }

        // Only one of the below while loops will run because if both the conditions are true then the above while loop will not stop.

        // Put all the remaining elements of first sorted array in the merged array.
        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }
        
        // Put all the remaining elements of second sorted array in the merged array.
        while(idx2 <= ei){
            merged[x++] = arr[idx2++];
        }

        // Restoring the elements of the original array according to the merged array. 
        for(int i = 0, j = si; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }

    }

    // This function is used to divide the array into its smallest possible sorted form.
    public static void divide(int[] arr, int si, int ei){
        if(si >= ei) return;

        int mid = si + (ei - si)/2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 3, 2, 5, 8};
        int n = arr.length;

        divide(arr, 0, n - 1);

        // Print the sorted array
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
