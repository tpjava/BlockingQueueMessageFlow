package com.perrin.tony.integrationtests;

import com.perrin.tony.consumer.Consumer;
import com.perrin.tony.producer.Producer;
import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.subscriber.Subscriber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class QueueIntegrationTests {
    @Mock
    public Producer producer;
    @Mock
    public Subscriber subscriber;
    @Mock
    public Consumer consumer;
    @Mock
    public Publisher publisher;

    @Test
    public void testFlowThroughQueues() {
        publisher.addSubscriber(subscriber);
        Mockito.verify(publisher).addSubscriber(subscriber);
        publisher.removeSubscriber(subscriber);
        Mockito.verify(publisher).removeSubscriber(subscriber);
        publisher.addSubscriber(subscriber);
    }

    @Test
    public void testProducer() {
        producer.init();
        Mockito.verify(producer).init();
        producer.isRunning();
        Mockito.verify(producer).isRunning();
        Mockito.when(producer.isRunning()).thenReturn(true);
        Assert.assertTrue(producer.isRunning());
        producer.stopPolling();
        Mockito.verify(producer).stopPolling();
        Mockito.when(producer.stopPolling()).thenReturn(true);
        Assert.assertTrue(producer.stopPolling());
    }
}
