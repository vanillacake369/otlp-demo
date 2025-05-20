package hama.soombilab.otlpdemo.feature.ownerBalance.usecase;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createOrder.usecase.OrderCreatedEvent;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.ChocoInfra;
import hama.soombilab.otlpdemo.infra.UserInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Transactional
public class AddOwnerBalance {

    private final ChocoInfra chocoInfra;
    private final UserInfra userInfra;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void addOwnerBalance(OrderCreatedEvent orderCreatedEvent){
        Order order = orderCreatedEvent.order();
        User owner = order.getProduct().getOwner();
        Money finalPrice = order.getFinalPrice();
        owner.addBalance(finalPrice);
        userInfra.save(owner);
        chocoInfra.addEarnedChoco(owner, finalPrice);
    }
}
