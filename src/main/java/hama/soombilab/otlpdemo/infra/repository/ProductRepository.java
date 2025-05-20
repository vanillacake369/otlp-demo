package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.Product;

public interface ProductRepository {

    Product findProduct(Long aLong);
}
