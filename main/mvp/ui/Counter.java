package main.mvp.ui;

public class Counter implements AutoCloseable {
    private int count;
    private boolean closed;

    public Counter() {
        count = 0;
        closed = false;
    }

    public int getCounter() {
        return count;
    }

    @Override
    public void close() {
        closed = true;
        count = 0;
    }

    public void add() {
        if (closed) {
            throw new RuntimeException("Counter is out of try_with_resources block");
        }
        count++;
    }
}
