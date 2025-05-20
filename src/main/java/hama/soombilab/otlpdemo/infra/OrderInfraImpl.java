package hama.soombilab.otlpdemo.infra;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.infra.data.OrderDao;
import hama.soombilab.otlpdemo.infra.data.OrderDaoRepository;
import hama.soombilab.otlpdemo.infra.data.ProductDao;
import hama.soombilab.otlpdemo.infra.data.ProductDaoRepository;
import hama.soombilab.otlpdemo.infra.data.UserDao;
import hama.soombilab.otlpdemo.infra.data.UserDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class OrderInfraImpl implements OrderInfra {

    private final UserDaoRepository userDaoRepository;
    private final ProductDaoRepository productDaoRepository;
    private final OrderDaoRepository orderDaoRepository;

    @Override
    public Order save(Order order) {
        UserDao buyerDao = UserDao.fromDomain(order.getBuyer());
        ProductDao productDao = ProductDao.fromDomain(order.getProduct());
        OrderDao orderDao = orderDaoRepository.save(OrderDao.fromDomain(buyerDao, productDao, order));
        return Order.fromDao(orderDao);
    }
}
