package com.example.concurrent;

public class AtomicBooleanTest {
    public static void main(String[] args) {
        new Thread(new User2("wjl")).start();
        new Thread(new User2("nl")).start();
        new Thread(new User2("wangjiliang")).start();
    }
}
