package com.linsen.leetcode.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarLockCondition {
    private int n;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition fooCondition = reentrantLock.newCondition();
    private Condition barCondition = reentrantLock.newCondition();
    //使用变量控制+condition可以代替自旋，使用while不使用锁也可以实现
    private int count = 1;

    public FooBarLockCondition(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            reentrantLock.lock();
            if(count != 1){
                fooCondition.await();
            }
            printFoo.run();
            barCondition.signal();
            count = 2;
            reentrantLock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            reentrantLock.lock();
            if(count != 2){
                barCondition.await();
            }
            printBar.run();
            fooCondition.signal();
            count = 1;
            reentrantLock.unlock();
        }
    }
}
