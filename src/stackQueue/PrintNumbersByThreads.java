import java.util.*;

public class PrintNumbersByThreads {

    public static void main(String[] args) throws Exception {
        Stack<Integer> op = new Stack<>();

        MyQueue q1 = new MyQueue(4);
        q1.push(1);q1.push(2);q1.push(7);q1.push(10);
        MyQueue q2 = new MyQueue(3);
        q2.push(4);q2.push(5);q2.push(8);
        MyQueue q3 = new MyQueue(3);
        q3.push(3);q3.push(6);q3.push(9);

        Thread t1 = new MyThread(q1, op, "t1");
        Thread t2 = new MyThread(q2, op, "t2");
        Thread t3 = new MyThread(q3, op, "t3");
        t2.start();
        t1.start();
        t3.start();
        t2.join();
        t1.join();
        t3.join();

        while (op.size() > 0) {
            System.out.println(op.pop());
        }
    }
}

class MyThread extends Thread {

    Stack<Integer> op = null;
    MyQueue q = null;

    public MyThread(MyQueue q, Stack op, String name) {
        this.q = q;
        this.op = op;
        this.setName(name);
    }

    public void run() {

        while (!q.isEmpty()) {
            synchronized (op) {
                int k = op.isEmpty() ? 0 : op.peek();
                if (k + 1 != this.q.peek()) {
                    try {
                        op.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    op.add(this.q.pop());
                    op.notifyAll();
                }
            }
        }
    }

}
