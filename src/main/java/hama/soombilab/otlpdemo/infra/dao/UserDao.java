package hama.soombilab.otlpdemo.infra.dao;

import hama.soombilab.otlpdemo.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    public static UserDao fromDomain(User user){
        return UserDao.builder()
            .uuid(user.getUuid())
            .name(user.getName())
            .phoneNumber(user.getPhoneNumber())
            .lastLogin(user.getLastLogin())
            .build();
    }
}
