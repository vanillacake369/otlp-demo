package hama.soombilab.otlpdemo.feature.buyerBalance;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createOrder.OrderCreatedEvent;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.repository.ChocoRepository;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Transactional
public class DeductBuyerBalance {

    private final ChocoRepository chocoRepository;
    private final UserRepository userRepository;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void deductBuyerBalance(OrderCreatedEvent orderCreatedEvent) {
        Order order = orderCreatedEvent.order();
        User buyer = order.getBuyer();
        Money finalPrice = order.getFinalPrice();
        buyer.deductBalance(finalPrice);
        userRepository.save(buyer);
        chocoRepository.addConsumedChoco(buyer, finalPrice);
    }
}
