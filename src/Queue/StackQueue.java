package Queue;

import java.util.Stack;

public class StackQueue {

    private Stack<Integer> first ;
    private Stack<Integer> second ;

    public StackQueue (){
        first = new Stack<Integer>();
        second = new Stack<Integer>();

    }

    public void enqueue(int item){
        first.push(item);
    }

    public int dequeue() {
        moveStack1ToStack2();
        return second.pop();

    }

    private void moveStack1ToStack2() {
        if (second.empty()) {
            while (!first.empty()) {
                second.push(first.pop());
            }
        }
    }

    public int peek(){
        moveStack1ToStack2();
        return second.peek();
    }

    public boolean isEmpty(){
        return(second.empty());
    }

    public boolean isFull(){
    return true;}


}
