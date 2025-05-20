package hama.soombilab.otlpdemo.feature.createOrder;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.Product;
import hama.soombilab.otlpdemo.domain.User;
import org.springframework.context.ApplicationEvent;

public record OrderCreatedEvent(
    Order order
) {

}
