import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element
    public void push(int x) {
        q1.offer(x);
    }

    // Pop element
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ans = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    // Return top element
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ans = q1.poll();

        q2.offer(ans);

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return ans;
    }

    // Check empty
    public boolean empty() {
        return q1.isEmpty();
    }
}