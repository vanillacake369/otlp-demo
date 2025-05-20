package hama.soombilab.otlpdemo.infra.repository;

import hama.soombilab.otlpdemo.domain.Order;
import hama.soombilab.otlpdemo.infra.dao.OrderDao;
import hama.soombilab.otlpdemo.infra.dao.OrderDaoRepository;
import hama.soombilab.otlpdemo.infra.dao.ProductDao;
import hama.soombilab.otlpdemo.infra.dao.ProductDaoRepository;
import hama.soombilab.otlpdemo.infra.dao.UserDao;
import hama.soombilab.otlpdemo.infra.dao.UserDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

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
