package naum.asafov.com.MinStack155;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.



 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    Stack<Integer> s;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int x) {
        if (s.empty()){
            min = x;
        }else {
            min = Math.min(min,x);
        }
        s.push(x);
    }

    public void pop() {
        if (min==s.pop()){
            min = Integer.MAX_VALUE;
        }
        Stack<Integer> temp = new Stack<>();
        while (!s.empty()){
            int i = s.pop();
            min = Math.min(min,i);
            temp.push(i);
        }
        while (!temp.isEmpty()){
            s.push(temp.pop());
        }

    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */