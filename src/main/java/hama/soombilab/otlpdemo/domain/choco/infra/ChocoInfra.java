package hama.soombilab.otlpdemo.domain.choco.infra;

import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.global.value.Money;

public interface ChocoInfra {

    void addEarnedChoco(User owner, Money finalPrice);

    void addConsumedChoco(User buyer, Money finalPrice);
}
