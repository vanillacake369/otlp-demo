package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.infra.dao.ConsumedChocoDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumedChocoDaoRepository extends JpaRepository<ConsumedChocoDao, Long> {

}