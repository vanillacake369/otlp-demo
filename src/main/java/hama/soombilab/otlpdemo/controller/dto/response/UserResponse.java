package hama.soombilab.otlpdemo.controller.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
    // 고객 ID
    UUID uuid,
    // 고객명
    String name,
    // 전화번호
    String phoneNumber,
    // 최근 로그인 날짜
    LocalDateTime lastLogin
) {

}
