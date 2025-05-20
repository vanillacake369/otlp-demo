package hama.soombilab.otlpdemo.feature.createOrder;

public interface CreateOrderUsecase {

    CreateOrderResponse createOrder(Long userIdx, CreatOrderRequest creatOrderRequest);
}
