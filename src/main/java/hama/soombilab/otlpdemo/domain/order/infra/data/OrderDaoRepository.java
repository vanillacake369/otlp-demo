package hama.soombilab.otlpdemo.domain.order.infra.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDaoRepository extends JpaRepository<OrderDao, Long> {

}