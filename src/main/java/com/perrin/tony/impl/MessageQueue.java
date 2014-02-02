package com.perrin.tony.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class MessageQueue<T> {
    protected final BlockingQueue<T> messageQueue = new LinkedBlockingQueue<T>();

    public boolean addMessage(T message) {
        return messageQueue.add(message);
    }

    public T removeMessage() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
