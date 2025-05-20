package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.infra.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<UserDao, Long> {

}