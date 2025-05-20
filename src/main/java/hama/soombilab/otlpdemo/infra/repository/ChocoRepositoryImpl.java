package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.User;
import hama.soombilab.otlpdemo.global.value.Money;
import hama.soombilab.otlpdemo.infra.dao.ConsumedChocoDao;
import hama.soombilab.otlpdemo.infra.dao.ConsumedChocoDaoRepository;
import hama.soombilab.otlpdemo.infra.dao.EarnedChocoDao;
import hama.soombilab.otlpdemo.infra.dao.EarnedChocoDaoRepository;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import hama.soombilab.otlpdemo.infra.dao.UserDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChocoRepositoryImpl implements ChocoRepository {

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
