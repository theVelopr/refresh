package ch04.s01;

/**
 * AbstractStack
 * -> Stack
 *
 * is_empty() :
 * push() :
 * pop() :
 * peek() :
 */

abstract class AbstractStack {
    protected int capacity;
    protected int top;

    public AbstractStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public abstract void push (int value);
    public abstract int pop();
    public abstract int peek();

}

class ArrayStact extends AbstractStack {
    private int [] array;

    public ArrayStact(int capacity) {
        super(capacity);
        array = new int[capacity];
    }

    @Override
    public void push(int value) {
        if (top == capacity) {
            int [] new_array = new int[capacity * 2];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            capacity *= 2;
        }
        array[top++] = value;
    }

    @Override
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        return array[--top];
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return array[top - 1];
    }
}

public class AbstractClassPractice {
    public static void main(String[] args) {
        ArrayStact stact = new ArrayStact(10);

        for (int i = 0; i < 15; i++) {
            stact.push(i);
        } // 0 - 9

        System.out.println(stact.peek());
        System.out.println(stact.peek());

        for (int i = 0; i < 20; i++) {
            System.out.println(stact.pop());
        }
    }
}
