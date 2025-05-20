package hama.soombilab.otlpdemo.feature.ownerBalance;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.feature.createOrder.OrderCreatedEvent;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.repository.ChocoRepository;
import hama.soombilab.otlpdemo.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class AddOwnerBalance {

    private final ChocoRepository chocoRepository;
    private final UserRepository userRepository;

    @EventListener
    public void addOwnerBalance(OrderCreatedEvent orderCreatedEvent){
        Order order = orderCreatedEvent.order();
        User owner = order.getProduct().getOwner();
        Money finalPrice = order.getFinalPrice();
        owner.addBalance(finalPrice);
        userRepository.save(owner);
        chocoRepository.addEarnedChoco(owner, finalPrice);
    }
}
