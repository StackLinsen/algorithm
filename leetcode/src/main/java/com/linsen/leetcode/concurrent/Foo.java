package com.linsen.leetcode.concurrent;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private Integer count = 1;
    private CountDownLatch secondCountDown = new CountDownLatch(1);
    private CountDownLatch thirdCountDown = new CountDownLatch(1);
    public Foo() {

    }



    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondCountDown.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondCountDown.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdCountDown.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdCountDown.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
