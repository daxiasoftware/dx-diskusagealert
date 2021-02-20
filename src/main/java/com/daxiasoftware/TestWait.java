package com.daxiasoftware;

public class TestWait {

    public static void main(String[] args) throws Exception {
        final Object o1 = new Object();
       
        new Thread() {
            public void run() {
                synchronized (o1) {
                    try {
                        System.out.println("wait...");
                        o1.wait();
                        System.out.println("done wait...");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
        }.start();
        
        Thread.sleep(2000);
        
        synchronized (o1) {
            System.out.println("notify...");
            o1.notify();
            o1.notify();
            o1.notify();
            o1.notify();

                System.out.println("done notify");
        }
        
        Thread.sleep(2000);
        
    }
}
