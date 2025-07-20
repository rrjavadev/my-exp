package threads;

public class PrintOddAndEvenThreadsInASequence {

    private volatile  Boolean isOddTurn = true;

    public synchronized void printOdd(int number) throws InterruptedException {
        while (!isOddTurn){
            wait();
        }
        if(number % 2 != 0) {
            System.out.println("Odd: " + number);
            isOddTurn = false;
            notifyAll();
        }
    }

    public synchronized void printEven(int number) throws InterruptedException {
        while (isOddTurn){
            wait();
        }
        if(number % 2 == 0) {
            System.out.println("Even: " + number);
            isOddTurn = true;
            notifyAll();
        }
    }
}
