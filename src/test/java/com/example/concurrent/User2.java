package com.example.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class User2 implements Runnable{
    private static AtomicBoolean flag = new AtomicBoolean(false);

    private String name;

    public User2(String name){
        this.name = name;
    }

    @Override
    public void run() {
        if(flag.compareAndSet(false, true)){
            System.out.println(name + "，起床了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "，上班了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "，下班了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println(name + "想进却进不来");
        }
    }
}
