package com.linsen.leetcode.concurrent;

public class ConcurrentMain {
    public static void main(String[] args) {
        FooBarSemaphore fooBar = new FooBarSemaphore(10);
        Runnable printFoo = () -> {
            System.out.println("foo");
        };

        Runnable printBar = () -> {
            System.out.println("bar");
        };

        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fooThread.start();
//        barThread.start();
    }
}
