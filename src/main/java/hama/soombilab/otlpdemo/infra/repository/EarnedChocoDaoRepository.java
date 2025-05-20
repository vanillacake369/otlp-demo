package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.infra.dao.EarnedChocoDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarnedChocoDaoRepository extends JpaRepository<EarnedChocoDao, Long> {

}