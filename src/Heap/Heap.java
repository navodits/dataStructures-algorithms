package Heap;

public class Heap {

   public int [] heap;
    int count = 0;

    public Heap(int size){
        heap = new int[size];
    }


    public void insert(int value){
        int index = count;

        heap [index] = value;
        while(index > 0 && heap[parent(index)] < heap[index]) {
            swap(parent(index), index);
            index= parent(index);
        }
        count++;
    }

    public int remove(){
        int index = 0;
        int item = heap[index];
        heap[index] = heap[count];
        count--;

        while(index <= count && !isValidParent(index)){
            int largerIndex = largerIndex(index);

                    swap(index, largerIndex);
                    index = largerIndex;

        }
        return item;
    }

    public int[] heapify(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(!hasLeftChild(i)){
                continue;
            }
            else if(!hasRightChild(i) && arr[i] < leftChild(i)){
                swap(i, leftChildIndex(i));
            }
            else if(arr[i] < leftChild(i) || arr[i] < rightChild(i)){
                swap(i, largerIndex(i));
            }

        }
        return arr;
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index)){
            return true;
        }
        if(!hasRightChild(index)){
            return heap[index] >= leftChild(index);
        }
        return heap[index] >= leftChild(index) && heap[index] >= rightChild(index);
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= count;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= count;
    }

    private int leftChild(int index){
        return heap[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return heap[rightChildIndex(index)];
    }

    private int largerIndex(int index){
        if(!hasLeftChild(index)){
            return index;
        }

        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }
        return leftChild(index) > rightChild(index)? leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChildIndex(int index){
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index){
        return (index * 2) + 2;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
