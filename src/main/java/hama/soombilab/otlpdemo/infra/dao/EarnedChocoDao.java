package hama.soombilab.otlpdemo.infra.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
public class EarnedChocoDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ecIdx;

    @Column
    private Long chEarnedChoco;

    @Column
    private Long chForeignKey;

    @Column
    private LocalDateTime chExpireDate;

    @Column
    private Boolean chIsFree;
}
