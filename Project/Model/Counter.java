package Model;

public class Counter implements AutoCloseable {

    static int sum;
    {
        sum = 0;
    }

    public void add() {
        sum++;
    }

    public int getCounter() {
        return sum;
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }
    
}
