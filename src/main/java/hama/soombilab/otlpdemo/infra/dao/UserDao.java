package hama.soombilab.otlpdemo.infra.dao;

import com.querydsl.core.annotations.QueryInit;
import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.global.value.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
@Getter
@Table
public class UserDao {

    @Id
    @Comment("고객 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column
    @Comment("고객명")
    private String name;

    @Column
    @Comment("전화번호")
    private String phoneNumber;

    @Column
    @Comment("최근 로그인 날짜")
    private LocalDateTime lastLogin;

    @Column
    @Comment("잔액")
    // @Embedded 사용하여 VO 그대로 사용해도 괜찮음. 예시이므로 일단 간단하게 진행
    private BigDecimal amount;

    public static UserDao fromDomain(User user) {
        return UserDao.builder()
            .uuid(user.getUuid())
            .name(user.getName())
            .phoneNumber(user.getPhoneNumber())
            .lastLogin(user.getLastLogin())
            .amount(user.getBalance().amount())
            .build();
    }
}
