package hama.soombilab.otlpdemo.infra;

import hama.soombilab.otlpdemo.domain.Product;

public interface ProductInfra {

    Product findProduct(Long aLong);
}
