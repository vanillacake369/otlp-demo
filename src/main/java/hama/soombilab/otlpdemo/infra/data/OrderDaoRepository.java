package hama.soombilab.otlpdemo.infra.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDaoRepository extends JpaRepository<OrderDao, Long> {

}