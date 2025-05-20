package hama.soombilab.otlpdemo.domain;

import hama.soombilab.otlpdemo.feature.createUser.CreatUserRequest;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import jakarta.persistence.Embedded;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    // 고객 ID
    private Long uuid;
    // 고객명
    private String name;
    // 전화번호
    private String phoneNumber;
    // 최근 로그인 날짜
    private LocalDateTime lastLogin;
    // 보유 포인트
    private Money balance;

    public static User fromDao(UserDao userDao){
        return User.builder()
            .uuid(userDao.getUuid())
            .name(userDao.getName())
            .phoneNumber(userDao.getPhoneNumber())
            .lastLogin(userDao.getLastLogin())
            .balance(new Money(userDao.getAmount()))
            .build();
    }

    public static User create(CreatUserRequest creatUserRequest) {
        return User.builder()
            .name(creatUserRequest.name())
            .phoneNumber(creatUserRequest.phoneNumber())
            .lastLogin(creatUserRequest.lastLogin())
            .build();
    }
}
