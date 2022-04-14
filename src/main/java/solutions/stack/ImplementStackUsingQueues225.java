package solutions.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {
    Queue<Integer> quque;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues225() {
        quque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.addAll(quque);
        quque =q;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return quque.poll();
    }

    /** Get the top element. */
    public int top() {
        return  quque.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return quque.isEmpty();
    }


}
