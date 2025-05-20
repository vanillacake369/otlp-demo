package hama.soombilab.otlpdemo.domain.product.infra.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDaoRepository extends JpaRepository<ProductDao, Long> {

}