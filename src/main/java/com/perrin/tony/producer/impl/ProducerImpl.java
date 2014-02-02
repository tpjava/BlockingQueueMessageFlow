package com.perrin.tony.producer.impl;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.consumerproducer.ConsumerProducerQueue;
import com.perrin.tony.producer.Producer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:32
 * To change this template use File | Settings | File Templates.
 */
public class ProducerImpl implements Producer {
    private ConsumerProducerQueue<String> consumerProducerQueue;
    private CountDownLatch countDownLatch;
    private volatile boolean running = false;

    @Override
    public void init() {
        consumerProducerQueue = ConsumerProducerQueue.getInstance();
        countDownLatch = new CountDownLatch(1);
        startGeneratingMessages();
    }

    private boolean startGeneratingMessages() {
        if(countDownLatch.getCount() == 0)
            init();

        Thread thread = new Thread(new ProducerRunnable());
        thread.start();
        try {
            countDownLatch.await(); //wait for polling to start.
        } catch (InterruptedException e) {
            throw new IllegalStateException("Could not correctly initialize producer.");
        }
        return true;
    }

    private class ProducerRunnable implements Runnable {
        @Override
        public void run() {
            running = true;

            while(running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addMessage(getUniqueMessage());

                if(countDownLatch.getCount() > 0)
                    countDownLatch.countDown();
            }
        }
    }

    private void addMessage(String message) {
        consumerProducerQueue.addMessage(message);
    }

    private String getUniqueMessage() {
        long timestamp = System.currentTimeMillis();
        return new String(Long.toHexString(timestamp));
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public boolean stopPolling() {
        return running = false;
    }

    @Override
    public boolean startPolling() {
        return running ? running : startGeneratingMessages();
    }
}
