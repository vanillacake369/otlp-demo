package hama.soombilab.otlpdemo.controller.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequest(
    // 고객명
    String name,
    // 전화번호
    String phoneNumber,
    // 최근 로그인 날짜
    LocalDateTime lastLogin
) {

}
