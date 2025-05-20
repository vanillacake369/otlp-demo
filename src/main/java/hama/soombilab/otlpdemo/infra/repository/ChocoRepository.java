package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.global.value.Money;

public interface ChocoRepository {

    void addEarnedChoco(User owner, Money finalPrice);

    void addConsumedChoco(User buyer, Money finalPrice);
}
