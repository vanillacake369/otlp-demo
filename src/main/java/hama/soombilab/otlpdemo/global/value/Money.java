package hama.soombilab.otlpdemo.global.value;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 금액을 표현한 값 객체. 등가성 비교: 속성 전체가 같으면 같은것으로 취급한다.
 *
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

    public static Money getFinalPrice(Money price, Long quantity) {
        return new Money(price.amount().multiply(BigDecimal.valueOf(quantity)));
    }

    public boolean isChargeable(Money finalPrice) {
        return amount.compareTo(finalPrice.amount()) >= 1;
    }

    public Money add(Money finalPrice) {
        return new Money(amount.add(finalPrice.amount()));
    }

    public Money sub(Money finalPrice) {
        return new Money(amount.subtract(finalPrice.amount()));
    }
}
