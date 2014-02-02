package com.perrin.tony.publishersubscriber;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.impl.MessageQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class PublisherSubscriberQueue<T> extends MessageQueue<T> {
    private static PublisherSubscriberQueue instance;

    private PublisherSubscriberQueue (){}

    public static PublisherSubscriberQueue getInstance() {
        if(instance == null) {
            synchronized (PublisherSubscriberQueue.class) {
                if(instance == null) {
                    instance = new PublisherSubscriberQueue<String>();
                }
            }
        }
        return instance;
    }
}
