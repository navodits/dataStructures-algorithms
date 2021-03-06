package SortingAlgorithms;

public class QuickSort {

    public void sort(int[] arr){
        sort(arr, 0, arr.length -1);
    }


    private void sort(int [] arr, int start, int end){

        if(start >= end){
            return;
        }

        int boundary = partition(arr, start, end);
        sort(arr, start, boundary-1);
        sort(arr,boundary+1, end);


    }

    public int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int counter = start - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                counter++;
                swap(i, counter, arr);

            }
        }
        return counter;
    }


    private void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
