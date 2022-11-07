package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.model.AddOrderForm;
import sean.secondhand_marketplace.entity.repository.OrderRepository;
import sean.secondhand_marketplace.entity.Orders;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Orders buyProduct(String consumer, AddOrderForm form) {
        return orderRepository.save(Orders.of(consumer, form));
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteAllById(id);
    }
}
