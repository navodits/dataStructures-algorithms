package Stack;

import java.util.NoSuchElementException;

public class Stack {
    int [] stack;
    int count = 0;

    public Stack(int size){
       stack  = new int[size];
    }

    public void push(int item){

        if(count == stack.length ){
            throw new StackOverflowError();
        }
        stack[count] = item;
        count++;
    }

    public int pop(){
        if(isEmpty()){
            throw  new NoSuchElementException();
        }
        int item = stack[count];
        stack[count] = 0;
        count--;
        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw  new NoSuchElementException();
        }
        return stack[count];
    }

    public boolean isEmpty(){
        if(count== 0){
            return true;
        }
        return false;
    }


}
