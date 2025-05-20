package hama.soombilab.otlpdemo.domain;

import hama.soombilab.otlpdemo.controller.dto.request.UserRequest;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
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

    public static User fromDao(UserDao userDao){
        return User.builder()
            .uuid(userDao.getUuid())
            .name(userDao.getName())
            .phoneNumber(userDao.getPhoneNumber())
            .lastLogin(userDao.getLastLogin())
            .build();
    }

    public static User create(UserRequest userRequest) {
        return User.builder()
            .name(userRequest.name())
            .phoneNumber(userRequest.phoneNumber())
            .lastLogin(userRequest.lastLogin())
            .build();
    }
}
