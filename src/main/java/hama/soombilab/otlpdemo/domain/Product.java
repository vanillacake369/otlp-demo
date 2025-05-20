package hama.soombilab.otlpdemo.domain;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class Product {

    private Long id;
    private String name;
    private Long quantity;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
}
