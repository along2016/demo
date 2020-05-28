package com.example.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.getAndSet(10));
        System.out.println(atomicInteger.getAndIncrement());
    }
}
