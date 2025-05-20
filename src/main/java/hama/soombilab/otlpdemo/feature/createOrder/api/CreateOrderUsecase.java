package hama.soombilab.otlpdemo.feature.createOrder.api;

import hama.soombilab.otlpdemo.feature.createOrder.api.dto.CreatOrderRequest;
import hama.soombilab.otlpdemo.feature.createOrder.api.dto.CreateOrderResponse;

public interface CreateOrderUsecase {

    CreateOrderResponse createOrder(Long userIdx, CreatOrderRequest creatOrderRequest);
}
