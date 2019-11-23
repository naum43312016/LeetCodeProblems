package naum.asafov.com.ImplementQueueusingStacks232;

import java.util.Stack;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
 */
public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(7);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}

class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        }else {

            Stack<Integer> temp=new Stack<>();
            while (!stack.isEmpty()){
                temp.push(stack.pop());
            }
            temp.push(x);
            while (!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */