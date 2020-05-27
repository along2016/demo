package com.example.concurrent;

public class User implements Runnable{
    private boolean flag = true;

    private String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public void run() {
        if(flag){
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

            flag = !flag;
        } else {
            System.out.println(name + "想进却进不来");
        }
    }
}
