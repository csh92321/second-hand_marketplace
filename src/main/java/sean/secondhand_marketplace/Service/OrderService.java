/*
    by 전성환
    주문 서비스에 관련된 기능.
 */

package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.entity.repository.MemberRepository;
import sean.secondhand_marketplace.entity.repository.ProductRepository;
import sean.secondhand_marketplace.model.AddOrderForm;
import sean.secondhand_marketplace.entity.repository.OrderRepository;
import sean.secondhand_marketplace.entity.Orders;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    //주문
    public Orders buyProduct(String consumer, AddOrderForm form) {
        Long sellerId = memberRepository.findIdByUsername(form.getSeller());
        Long consumerId = memberRepository.findIdByUsername(consumer);
        Long productId = productRepository.findIdByProductName(form.getProductName());
        return orderRepository.save(Orders.of(consumer, sellerId, consumerId, productId, form));
    }

    //주문을 취소
    public void cancelOrder(Long id) {
        orderRepository.deleteAllById(id);
    }
}
