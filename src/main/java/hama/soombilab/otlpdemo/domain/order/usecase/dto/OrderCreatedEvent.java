package hama.soombilab.otlpdemo.domain.order.usecase.dto;

import hama.soombilab.otlpdemo.domain.order.model.Order;

public record OrderCreatedEvent(
    Order order
) {

}
