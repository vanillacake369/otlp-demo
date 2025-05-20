package hama.soombilab.otlpdemo.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PROTECTED)
public class Choco {

    private List<EarnedChoco> earnedChocos;
    private List<ConsumedChoco> consumedChocos;

    @Getter
    @Builder(access = AccessLevel.PROTECTED)
    public static class ConsumedChoco {
        private Long consumedChocoId;
        private Long chConsumedChoco;
        private Long chForeignKey;
        private LocalDateTime chExpireDate;
        private Boolean chIsFree;
    }

    @Getter
    @Builder(access = AccessLevel.PROTECTED)
    public static class EarnedChoco {
        private Long earnedChocoId;
        private Long chEarnedChoco;
        private Long chForeignKey;
        private LocalDateTime chExpireDate;
        private Boolean chIsFree;
    }
}
