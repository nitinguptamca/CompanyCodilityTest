package com.example.prectise;

public class PrintNumberInSequence {

    public static void main(String[] args) {
        PrintNumberInSequence obj = new PrintNumberInSequence();
        Thread t1 = new Thread(new SequenceRunnable(obj, 0), "T1");
        Thread t2 = new Thread(new SequenceRunnable(obj, 1), "T2");
        Thread t3 = new Thread(new SequenceRunnable(obj, 2), "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static class SequenceRunnable implements Runnable {
        PrintNumberInSequence obj;
        int threadNumber;
        static volatile int counter = 0;

        public SequenceRunnable(PrintNumberInSequence obj, int threadNumber) {
            this.obj = obj;
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (counter < 10) {
                   // System.out.print("\n"+ Thread.currentThread().getName()  + " threadNumber  "+this.threadNumber);
                    while (counter%3 !=threadNumber){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()  + "counter "+counter);
                    counter ++;
                    obj.notifyAll();
                }
            }
        }
    }
}
