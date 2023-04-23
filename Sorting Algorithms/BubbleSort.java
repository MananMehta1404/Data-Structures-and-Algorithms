class BubbleSort{ 

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }   

    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 2, -1, 23, -50, 5};
        int n = arr.length;

        // Bubble Sort -> Sorting the elements in the ascending order.
        // Time Complexity -> O(n^2) (n = length of array)
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printArray(arr);
    }
}