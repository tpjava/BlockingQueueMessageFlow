package com.perrin.tony.publisher;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.subscriber.Subscriber;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 08:35
 * To change this template use File | Settings | File Templates.
 */
public interface Publisher {
    public void init();
    boolean addSubscriber(Subscriber subscriber);
    boolean removeSubscriber(Subscriber subscriber);
}
