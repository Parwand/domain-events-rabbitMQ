package net.parwand.consumer.listener;


import net.parwand.consumer.configuration.MQConfig;
import net.parwand.consumer.domain.Product;
import net.parwand.consumer.domain.Shipment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @AUTHOR Parwand Alsino
 */
@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.PRODUCT_QUEUE)
    public void receiveProduct(Product product){
        Shipment shipment = new Shipment(UUID.randomUUID(), LocalDate.now(), product.getId());
        System.out.println("You have to ship this Product: "+ product);
        System.out.println("New Shipping: "+ shipment);
    }
}
