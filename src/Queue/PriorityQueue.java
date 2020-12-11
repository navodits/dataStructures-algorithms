package Queue;

import java.util.Arrays;

public class PriorityQueue {
    int [] pQueue;
    int index = 0;

    public PriorityQueue(int size){
        pQueue = new int[size];
    }

    public void add(int item){


        int i;
        for (i = index -1  ; i >= 0; i--) {
            if(item < pQueue[i]){
                pQueue[i+1] = pQueue[i];        //5 , 3 , 1, 6
            }                                  //5, 5,
            else break;
        }
        pQueue[i+1] = item;
        index++;
    }

    @Override
    public String toString(){
       return Arrays.toString(pQueue);
    }

    public int dequeue(){

        return 0;


    }
    public boolean isEmpty(){
        return true;
    }

}
