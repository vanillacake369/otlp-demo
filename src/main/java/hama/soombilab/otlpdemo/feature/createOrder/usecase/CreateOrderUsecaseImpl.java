package hama.soombilab.otlpdemo.feature.createOrder.usecase;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.Product;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createOrder.api.dto.CreatOrderRequest;
import hama.soombilab.otlpdemo.feature.createOrder.api.dto.CreateOrderResponse;
import hama.soombilab.otlpdemo.feature.createOrder.api.CreateOrderUsecase;
import hama.soombilab.otlpdemo.infra.ProductInfra;
import hama.soombilab.otlpdemo.infra.OrderInfra;
import hama.soombilab.otlpdemo.infra.UserInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class CreateOrderUsecaseImpl implements CreateOrderUsecase {

    private final UserInfra userInfra;
    private final ProductInfra productInfra;
    private final OrderInfra orderInfra;
    private final CreateOrderUsecaseMapper createOrderUsecaseMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public CreateOrderResponse createOrder(Long userIdx, CreatOrderRequest creatOrderRequest) {
        User buyer = userInfra.findUser(userIdx);
        Product product = productInfra.findProduct(creatOrderRequest.prdIdx());
        Order order = orderInfra.save(Order.createFrom(buyer, product,creatOrderRequest.quantity()));
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(order));
        return createOrderUsecaseMapper.toCreateOrderResponse(order);
    }
}
