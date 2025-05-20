package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.Product;
import hama.soombilab.otlpdemo.infra.dao.ProductDao;
import hama.soombilab.otlpdemo.infra.dao.ProductDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDaoRepository productDaoRepository;

    @Override
    public Product findProduct(Long idx) {
        ProductDao productDao = productDaoRepository
            .findById(idx)
            .orElseThrow(() -> new RuntimeException("Product Not Found"));
        return Product.fromDao(productDao);
    }
}
