package hama.soombilab.otlpdemo.domain.product.infra;

import hama.soombilab.otlpdemo.domain.product.model.Product;

public interface ProductInfra {

    Product findProduct(Long aLong);
}
