package net.parwand.producer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String PRODUCT_QUEUE = "Product_Queue";
    public static final String PRODUCT_EXCHANGE = "Product_Exchange";
    public static final String PRODUCT_ROUTING_KEY = "Product_Routing_Key";

    @Bean
    Queue queue(){
        return new Queue(PRODUCT_QUEUE);
    }

    @Bean
    Exchange exchange(){
        return new TopicExchange(PRODUCT_EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PRODUCT_ROUTING_KEY)
                .noargs();
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
