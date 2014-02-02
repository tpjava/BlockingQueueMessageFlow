package com.perrin.tony.consumerproducer;/**
 * Created by tonyperrin on 30/01/2014.
 */

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerProducerQueueTest {
    private ConsumerProducerQueue consumerProducerQueue;

    @Before
    public void testSetup() {
        consumerProducerQueue = ConsumerProducerQueue.getInstance();
    }

    @Test
    public void testConsumerProducerQueue() {
        Assert.assertNotNull(consumerProducerQueue);
    }

    @Test
    public void testAddMessageToQueue() {
        Assert.assertTrue(consumerProducerQueue.addMessage("hello world"));
    }
}
