package com.perrin.tony.publisher;/**
 * Created by tonyperrin on 02/02/2014.
 */

import com.perrin.tony.publisher.impl.PublisherImpl;
import com.perrin.tony.subscriber.Subscriber;
import com.perrin.tony.subscriber.impl.SubscriberImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 02/02/2014
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class PublisherTest {
    private Publisher publisher;
    private Subscriber subscriber;

    @Before
    public void testSetup() {
        publisher =  new PublisherImpl();
        subscriber = new SubscriberImpl();
    }

    @Test
    public void testSubscriber() {
        Assert.assertNotNull(publisher);
    }
}
