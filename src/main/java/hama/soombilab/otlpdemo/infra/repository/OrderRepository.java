package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.Order;

public interface OrderRepository {

    Order save(Order from);
}
