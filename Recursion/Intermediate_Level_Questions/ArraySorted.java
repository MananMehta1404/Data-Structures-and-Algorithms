public class ArraySorted {

    // Time Complexity -> O(n)
    public static boolean isStrictlyIncreasing(int[] arr, int idx){
        if(idx == arr.length - 1){
            return true;
        }
        if(arr[idx] < arr[idx + 1]) {
            // Array is sorted till now
            return isStrictlyIncreasing(arr, idx + 1);
        }
        else return false;
    }

    // Time Complexity -> O(n)
    public static boolean isStrictlyDecreasing(int[] arr, int idx){
        if(idx == arr.length - 1){
            return true;
        }
        if(arr[idx] > arr[idx + 1]) {
            // Array is sorted till now
            return isStrictlyDecreasing(arr, idx + 1);
        }
        else return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isStrictlyIncreasing(arr, 0));
        System.out.println(isStrictlyDecreasing(arr, 0));
    }
}
