package com.linsen.leetcode.concurrent;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FooBarCyclicBarrier {
    private int n;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    private volatile boolean fin = true;


    public FooBarCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while(!fin);
            printFoo.run();
            fin = false;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
            }
            printBar.run();
            fin = true;
        }
    }
}
