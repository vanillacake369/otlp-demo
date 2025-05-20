package hama.soombilab.otlpdemo.domain.choco.infra.data;

import hama.soombilab.otlpdemo.domain.user.infra.data.UserDao;
import hama.soombilab.otlpdemo.global.value.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table
@Getter
@Entity
@DynamicUpdate
@DynamicInsert
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConsumedChocoDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuid", nullable = false)
    private UserDao userDao;

    @Column
    private BigDecimal chConsumedChoco;

    public static ConsumedChocoDao from(UserDao userDao, Money finalPrice) {
        return ConsumedChocoDao.builder()
            .userDao(userDao)
            .chConsumedChoco(finalPrice.amount())
            .build();
    }
}
