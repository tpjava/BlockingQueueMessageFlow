package com.perrin.tony.publisher.impl;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.publishersubscriber.PublisherSubscriberQueue;
import com.perrin.tony.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:35
 * To change this template use File | Settings | File Templates.
 */
public class PublisherImpl implements Publisher {
    private PublisherSubscriberQueue<String> publisherSubscriberQueue;
    private List<Subscriber> subscriberList = new ArrayList<Subscriber>();

    @Override
    public void init() {
        publisherSubscriberQueue = PublisherSubscriberQueue.getInstance();
        startConsumingMessages();
    }

    @Override
    public boolean addSubscriber(Subscriber subscriber) {
        return subscriberList.add(subscriber);
    }

    @Override
    public boolean removeSubscriber(Subscriber subscriber) {
        return subscriberList.remove(subscriber);
    }

    private void startConsumingMessages() {
        new Thread(new ConsumerRunnable()).start();
    }

    private class ConsumerRunnable implements Runnable {
        @Override
        public void run() {
            while(true) {
                String message = publisherSubscriberQueue.removeMessage();
                updateSubscribers(message);
            }
        }
    }

    private void updateSubscribers(String message) {
        for(Subscriber subscriber : subscriberList) {
            subscriber.onMessage(message);
        }
    }

}
