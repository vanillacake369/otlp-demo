package hama.soombilab.otlpdemo.infra;

import hama.soombilab.otlpdemo.domain.Order;

public interface OrderInfra {

    Order save(Order from);
}
