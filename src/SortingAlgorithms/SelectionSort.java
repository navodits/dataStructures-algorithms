package SortingAlgorithms;

public class SelectionSort {



    public int[] sort(int[] arr){
        int count = 0;
        ;
        int startIndex = 0;
        while(startIndex < arr.length){
            int minIndex =  startIndex;
            for (int i = startIndex; i < arr.length; i++) {

                if(arr[i] <= arr[minIndex]){
                    minIndex = i;
                }
            }
            swap(startIndex, minIndex, arr);
            startIndex++;
        }
     return arr;
    }

    public void swap( int a, int b, int[] arr){
        int temp;

        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
