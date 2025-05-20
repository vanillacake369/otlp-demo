package hama.soombilab.otlpdemo.feature.createOrder.usecase;

import hama.soombilab.otlpdemo.domain.Order;

public record OrderCreatedEvent(
    Order order
) {

}
