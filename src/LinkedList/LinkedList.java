package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }
    }
    private Node first;
    private Node last;
    private int size = 0;

    public void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else{
        last.next = node;
        last = node;}

        size++;
    }

    public void deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(first== last){
            first = last = null;
        }
        else {
            Node tmp = first.next;
            first.next = null;
            first = tmp;
        }
        size--;
    }

    public void print(){
        Node current = first ;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void deleteLast(){

        if(isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }
        else {
            Node previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }
        size--;

    }

    public int getSize() {
        return size;
    }

    public int indexOf(int value){
        Node current = first ;
        int count = 0;
        while(current != null) {
            if (current.value == value) {
                return count;
            }
            else{
                current = current.next;
            }
            count += 1;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPrevious(Node node){
        Node current = first;
         while (current != null){
             if(current.next == last) return current;
             current = current.next;

         }
         return null;
    }

    public int[] toArray(){
        int[] arr = new int[size];
        int index = 0;
        Node current = first;

        while(current != null){
            arr[index] = current.value;
            index++;
            current = current.next;
        }
        return arr;
    }

    public void reverse(){
        // 5 -> 10 -> 20 -> 40
        // 5 <- 10 <- 20 <- 40
        if(isEmpty())return;

        Node p = first;
        Node c = first.next;

        last = p;

        while(c != null){
            Node n = c.next;
            c.next = p;
            p = c;
            c = n;
            if(n == first) break;
            else {
                n = n.next;
            }
            if(n.next == null){
                n.next = c;
                first = n;
            }

        }
        last.next= null;

    }

    public Node getKthFromTheEnd(int index){
        var current = first;
        var k = first;
        int count = 0;

        while(current.next != null){
            if(count >= index - 1){
                k = k.next;
            }
            current = current.next;
            count++;
        }
        System.out.println(k.value);

        return k;
    }
}
