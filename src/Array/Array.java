package Array;

public class Array {
    int[] arr;
    int count = 0;
    public Array(int size){
        arr = new int[size];
    }

    public void insert(int num){
        arr[count] = num;
        count = count + 1;
        if(count == arr.length){
            int[] copy = arr;
            arr = new int[arr.length * 2];
            for (int i = 0; i < copy.length ; i++) {
                arr[i]= copy[i];
            }
        }

    }

    public void removeAt(int index){
        arr[index] = 0;
        if(index >= count){
            return;
        }
        for (int i = index; i < count ; i++) {
            arr[index] = arr[index + 1];
            count--;
        }
    }

    public int indexOf(int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return i;}
        }
        return -1;

    }
}

