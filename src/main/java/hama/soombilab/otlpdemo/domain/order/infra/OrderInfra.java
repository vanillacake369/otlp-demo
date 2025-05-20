package hama.soombilab.otlpdemo.domain.order.infra;

import hama.soombilab.otlpdemo.domain.order.model.Order;

public interface OrderInfra {

    Order save(Order from);
}
