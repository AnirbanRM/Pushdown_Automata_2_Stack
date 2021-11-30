package PDA2Stack;

public class Stack<T> implements Cloneable{

    private static class Node<T>{
        Node<T> nextNode;
        T data;

        Node(T data, Node<T> nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    private Node<T> head;
    private int length;

    Stack(){
        head = null;
        length = 0;
    }

    void push(T data){
        if(head==null)
            head = new Node<T>(data,null);
        else
            head = new Node<T>(data,head);
        length++;
    }

    T pop(){
        if(head==null)
            return null;

        length--;
        Node<T> r = head;
        head = head.nextNode;
        return r.data;
    }

    T peek(){
        if(head==null)
            return null;
        return head.data;
    }

    int getLength(){
        return length;
    }

    void printStack(){
        Node<T> currentNode = head;
        System.out.print("["+getLength()+"] ");
        while(currentNode!=null){
            System.out.print(currentNode.data);
            System.out.print(" -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("*");
    }

    boolean isEmpty(){
        return length==0;
    }

    @Override
    public Stack<T> clone() {
        Stack<T> clone = new Stack<>();
        if(head==null)
            return clone;

        Stack<T> tempStack = new Stack<>();
        Node<T> currentNode = head;
        while(currentNode!=null){
            tempStack.push(currentNode.data);
            currentNode = currentNode.nextNode;
        }

        while(!tempStack.isEmpty())
            clone.push(tempStack.pop());

        return clone;
    }
}
