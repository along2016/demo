package com.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static AtomicInteger counter = new AtomicInteger();

    public static void increment(){
        counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Counter.increment();
                latch.countDown();
            }).start();
        }
        latch.await();

        System.out.println(counter.get());
    }
}
