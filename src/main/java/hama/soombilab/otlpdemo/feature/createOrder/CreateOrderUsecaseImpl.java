package hama.soombilab.otlpdemo.feature.createOrder;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.Product;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.infra.repository.ProductRepository;
import hama.soombilab.otlpdemo.infra.repository.OrderRepository;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class CreateOrderUsecaseImpl implements CreateOrderUsecase {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CreateOrderUsecaseMapper createOrderUsecaseMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public CreateOrderResponse createOrder(Long userIdx, CreatOrderRequest creatOrderRequest) {
        User buyer = userRepository.findUser(userIdx);
        Product product = productRepository.findProduct(creatOrderRequest.prdIdx());
        Order order = orderRepository.save(Order.createFrom(buyer, product,creatOrderRequest.quantity()));
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(order));
        return createOrderUsecaseMapper.toCreateOrderResponse(order);
    }
}
