package com.perrin.tony.subscriber;/**
 * Created by tonyperrin on 31/01/2014.
 */

import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.publisher.impl.PublisherImpl;
import com.perrin.tony.subscriber.impl.SubscriberImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
public class SubscriberTest {
    private Subscriber subscriber;
    private Publisher publisher;

    @Before
    public void testSetup() {
        subscriber =  new SubscriberImpl();
        publisher = new PublisherImpl();
    }

    @Test
    public void testSubscriber() {
        Assert.assertNotNull(subscriber);
    }

    @Test
    public void testAddRemoveSubscriber() {
        Assert.assertTrue(publisher.addSubscriber(subscriber));
        Assert.assertTrue(publisher.removeSubscriber(subscriber));
    }
}
