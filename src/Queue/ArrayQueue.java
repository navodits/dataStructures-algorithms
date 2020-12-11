package Queue;

public class ArrayQueue {
    int start = 0;
    int end = 0;
    int [] queue ;

    public ArrayQueue(int size){
        queue = new int[size];
    }

    public void enqueue(int item){

        if(isFull()) throw new IllegalStateException();

        queue[end] = item;
        end++;
        end = end % queue.length;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();
      int item = queue[start];
      start++;
      start = start % queue.length;

      return item;
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException();
        return queue[start];

    }

    public boolean isEmpty(){
        return ((start + end) == 0);
    }

    public boolean isFull(){
        return ((start + end) == queue.length);
    }
}
