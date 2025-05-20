package hama.soombilab.otlpdemo.domain.order.api;

import hama.soombilab.otlpdemo.domain.order.api.dto.CreatOrderRequest;
import hama.soombilab.otlpdemo.domain.order.api.dto.CreateOrderResponse;

public interface CreateOrderUsecase {

    CreateOrderResponse createOrder(Long userIdx, CreatOrderRequest creatOrderRequest);
}
