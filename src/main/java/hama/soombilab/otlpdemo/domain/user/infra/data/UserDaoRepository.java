package hama.soombilab.otlpdemo.domain.user.infra.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDaoRepository extends JpaRepository<UserDao, Long> {

}