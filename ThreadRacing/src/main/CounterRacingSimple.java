package main;

public class CounterRacingSimple {

    public static void main(String[] args) {

        // 1) We use anonymous object , once.
        new CounterRacingSimple().doCounter();
    }

    private int count = 0;

    private synchronized void increment() {
        count++;
    }

    private void doCounter() {

        // 2) Class Thread implements interface Runnable.
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                // 3) The loop will work till 1000000 for both objects.
                for(int i = 0; i < 1_000_000; i++) {
                    increment();
                }
                System.out.println("t1: " + count);

            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i < 1_000_000; i++) {
                    increment();
                }
                System.out.println("t2: " + count);

            }
        });

       
        t1.start();
        t2.start();
    }

//    5) Because the Thread working asynchronous.
}
