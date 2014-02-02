package com.perrin.tony.consumer.impl;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.consumer.Consumer;
import com.perrin.tony.consumerproducer.ConsumerProducerQueue;
import com.perrin.tony.publishersubscriber.PublisherSubscriberQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerImpl implements Consumer {
    private ConsumerProducerQueue<String> consumerProducerQueue;
    private PublisherSubscriberQueue<String> publisherSubscriberQueue;
    private CountDownLatch countDownLatch;
    private volatile boolean running = false;

    @Override
    public void init() {
        consumerProducerQueue = ConsumerProducerQueue.getInstance();
        publisherSubscriberQueue = PublisherSubscriberQueue.getInstance();
        countDownLatch = new CountDownLatch(1);
        startConsumingMessages();
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public boolean stopPolling() {
        return running = false;
    }

    @Override
    public boolean startPolling() {
        return running ? running : startConsumingMessages();
    }

    private boolean startConsumingMessages() {
        if(countDownLatch.getCount() == 0)
            init();

        Thread thread = new Thread(new ConsumerRunnable());
        thread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Could not correctly initialize consumer.");
        }
        return true;
    }

    private class ConsumerRunnable implements Runnable {
        @Override
        public void run() {
            running = true;

            while(running) {
                if(countDownLatch.getCount() > 0)
                    countDownLatch.countDown();

                String message = consumerProducerQueue.removeMessage();
                publisherSubscriberQueue.addMessage(message);
            }
        }
    }
}
