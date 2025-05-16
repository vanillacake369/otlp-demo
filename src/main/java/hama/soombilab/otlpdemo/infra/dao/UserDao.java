package hama.soombilab.otlpdemo.infra.dao;

import hama.soombilab.otlpdemo.domain.User;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record UserDao(
    // 고객 ID
    UUID uuid,
    // 고객명
    String name,
    // 전화번호
    String phoneNumber,
    // 최근 로그인 날짜
    LocalDateTime lastLogin
) {
    public static UserDao fromDomain(User user){
        return UserDao.builder()
            .uuid(user.getUuid())
            .name(user.getName())
            .phoneNumber(user.getPhoneNumber())
            .lastLogin(user.getLastLogin())
            .build();
    }
}
