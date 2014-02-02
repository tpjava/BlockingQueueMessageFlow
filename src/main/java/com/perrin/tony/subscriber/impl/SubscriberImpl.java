package com.perrin.tony.subscriber.impl;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.subscriber.Subscriber;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:37
 * To change this template use File | Settings | File Templates.
 */
public class SubscriberImpl implements Subscriber {

    @Override
    public void onMessage(String message) {
        System.out.println("received message in subscriber." + message);
    }
}
