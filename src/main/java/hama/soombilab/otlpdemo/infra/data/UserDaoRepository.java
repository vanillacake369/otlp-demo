package hama.soombilab.otlpdemo.infra.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<UserDao, Long> {

}