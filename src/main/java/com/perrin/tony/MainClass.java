package com.perrin.tony;

import com.perrin.tony.consumer.Consumer;
import com.perrin.tony.consumer.impl.ConsumerImpl;
import com.perrin.tony.producer.Producer;
import com.perrin.tony.producer.impl.ProducerImpl;
import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.publisher.impl.PublisherImpl;
import com.perrin.tony.subscriber.Subscriber;
import com.perrin.tony.subscriber.impl.SubscriberImpl;

/**
 * Hello world!
 *
 */
public class MainClass
{
    public static void main( String[] args ) {
        Producer producer = new ProducerImpl();
        Consumer consumer = new ConsumerImpl();
        consumer.init();
        producer.init();
        Publisher publisher = new PublisherImpl();
        Subscriber subscriberOne = new SubscriberImpl();
        Subscriber subscriberTwo = new SubscriberImpl();
        publisher.init();
        publisher.addSubscriber(subscriberOne);
        publisher.addSubscriber(subscriberTwo);
    }
}
