package hama.soombilab.otlpdemo.domain.product.infra;

import hama.soombilab.otlpdemo.domain.product.infra.data.ProductDao;
import hama.soombilab.otlpdemo.domain.product.infra.data.ProductDaoRepository;
import hama.soombilab.otlpdemo.domain.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class ProductInfraImpl implements ProductInfra {

    private final ProductDaoRepository productDaoRepository;

    @Override
    public Product findProduct(Long idx) {
        ProductDao productDao = productDaoRepository
            .findById(idx)
            .orElseThrow(() -> new RuntimeException("Product Not Found"));
        return Product.fromDao(productDao);
    }
}
