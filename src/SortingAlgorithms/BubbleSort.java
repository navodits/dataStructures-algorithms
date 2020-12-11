package SortingAlgorithms;

public class BubbleSort {

    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++){
                if(arr[j] > arr[j+1]) {
                    swap(j, j+1, arr);
                }
            }
        }
        return arr;
    }

    private void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
