package hama.soombilab.otlpdemo.global.value;

import java.math.BigDecimal;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 금액을 표현한 값 객체.
 * 등가성 비교: 속성 전체가 같으면 같은것으로 취급한다.
 * @param amount 불변(immutable)
 */
public record Money(
    BigDecimal amount
) {

    public Money {
        if (Objects.isNull(amount)) { // 무결성 유지 Validation
            throw new IllegalArgumentException("금액이 Null일 수 없습니다.");
        }
    }
}
