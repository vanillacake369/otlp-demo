package hama.soombilab.otlpdemo.feature.createUser;

import java.time.LocalDateTime;

public record CreateUserResponse(
    // 고객 ID
    Long uuid,
    // 고객명
    String name,
    // 전화번호
    String phoneNumber,
    // 최근 로그인 날짜
    LocalDateTime lastLogin
) {

}
