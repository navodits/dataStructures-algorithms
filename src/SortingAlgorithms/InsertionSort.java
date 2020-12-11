package SortingAlgorithms;

public class InsertionSort {

    public int[] sort(int [] arr){
        int unsortedIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int current = arr[i];
            while( j >= 0 && arr[j] > current){

                    arr[j +1] = arr[j];
                    j--;

                }
            if(j != i-1) {
                arr[j+1] = current;
            }
        }
        return arr;
    }
}
