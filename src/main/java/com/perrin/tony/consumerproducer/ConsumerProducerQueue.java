package com.perrin.tony.consumerproducer;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.impl.MessageQueue;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 21:36
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerProducerQueue<T> extends MessageQueue<T> {
    private static ConsumerProducerQueue instance;

    private ConsumerProducerQueue (){}

    public static ConsumerProducerQueue<String> getInstance() {
        if(instance == null) {
            synchronized (ConsumerProducerQueue.class) {
                if(instance == null) {
                    instance = new ConsumerProducerQueue<String>();
                }
            }
        }
        return instance;
    }
}
