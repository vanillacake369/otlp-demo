package hama.soombilab.otlpdemo.domain.choco.infra;

import hama.soombilab.otlpdemo.domain.choco.infra.data.ConsumedChocoDao;
import hama.soombilab.otlpdemo.domain.choco.infra.data.ConsumedChocoDaoRepository;
import hama.soombilab.otlpdemo.domain.choco.infra.data.EarnedChocoDao;
import hama.soombilab.otlpdemo.domain.choco.infra.data.EarnedChocoDaoRepository;
import hama.soombilab.otlpdemo.domain.user.model.User;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.domain.user.infra.data.UserDao;
import hama.soombilab.otlpdemo.domain.user.infra.data.UserDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChocoInfraImpl implements ChocoInfra {

    private final UserDaoRepository userDaoRepository;
    private final EarnedChocoDaoRepository earnedChocoDaoRepository;
    private final ConsumedChocoDaoRepository consumedChocoDaoRepository;

    @Override
    public void addEarnedChoco(User owner, Money finalPrice) {
        UserDao userDao = userDaoRepository
            .findById(owner.getUuid())
            .orElseThrow(() -> new RuntimeException("User Not Found"));
        EarnedChocoDao earnedChocoDao = EarnedChocoDao.from(userDao, finalPrice);
        earnedChocoDaoRepository.save(earnedChocoDao);
    }

    @Override
    public void addConsumedChoco(User buyer, Money finalPrice) {
        UserDao userDao = userDaoRepository
            .findById(buyer.getUuid())
            .orElseThrow(() -> new RuntimeException("User Not Found"));
        ConsumedChocoDao consumedChocoDao = ConsumedChocoDao.from(userDao, finalPrice);
        consumedChocoDaoRepository.save(consumedChocoDao);
    }
}
