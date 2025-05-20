package hama.soombilab.otlpdemo.infra;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.global.value.Money;

public interface ChocoInfra {

    void addEarnedChoco(User owner, Money finalPrice);

    void addConsumedChoco(User buyer, Money finalPrice);
}
