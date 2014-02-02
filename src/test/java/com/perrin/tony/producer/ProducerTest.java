package com.perrin.tony.producer;

import com.perrin.tony.producer.impl.ProducerImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 31/01/2014
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */

public class ProducerTest {
    private Producer producer;

    @Before
    public void testSetup() {
        producer = new ProducerImpl();
    }

    @Test
    public void testProducerPolling() {
        producer.init();
        Assert.assertTrue(producer.isRunning());
        producer.stopPolling();
    }

    @Test
    public void testProducerStopPolling() {
        producer.init();
        Assert.assertTrue(producer.isRunning());
        producer.stopPolling();
        Assert.assertFalse(producer.isRunning());
    }

    @Test
    public void testRestartPolling() {
        producer.init();
        Assert.assertTrue(producer.isRunning());
        producer.stopPolling();
        Assert.assertFalse(producer.isRunning());
        producer.startPolling();
        Assert.assertTrue(producer.isRunning());
    }
}
