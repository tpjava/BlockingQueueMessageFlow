package com.perrin.tony.consumer;/**
 * Created by tonyperrin on 02/02/2014.
 */

import com.perrin.tony.consumer.impl.ConsumerImpl;
import com.perrin.tony.producer.Producer;
import com.perrin.tony.producer.impl.ProducerImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 02/02/2014
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerTest {
    private Consumer consumer;
    private Producer producer;

    @Before
    public void testSetup() {
        consumer = new ConsumerImpl();
        producer = new ProducerImpl();  //needed to test Consumer.
    }

    @Test
    public void testConsumerPolling() {
        producer.init();
        consumer.init();
        Assert.assertTrue(consumer.isRunning());
    }

    @Test
    public void testProducerStopPolling() {
        producer.init();
        consumer.init();
        Assert.assertTrue(consumer.isRunning());
        consumer.stopPolling();
        Assert.assertFalse(consumer.isRunning());
    }

    @Test
    public void testRestartPolling() {
        consumer.init();
        Assert.assertTrue(consumer.isRunning());
        consumer.stopPolling();
        Assert.assertFalse(consumer.isRunning());
        consumer.startPolling();
        Assert.assertTrue(consumer.isRunning());
    }
}
