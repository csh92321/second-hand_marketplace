/*
    by 전성환
    주문과 관련된 컨트롤러 구현.
 */

package sean.secondhand_marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.secondhand_marketplace.Service.OrderService;
import sean.secondhand_marketplace.model.OrderDto;
import sean.secondhand_marketplace.model.AddOrderForm;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //주문 등록
    @PostMapping("/buy")
    public ResponseEntity<OrderDto> buyProduct(@RequestParam String consumer, @RequestBody AddOrderForm form) {
        return ResponseEntity.ok(OrderDto.from(orderService.buyProduct(consumer, form)));
    }

    //주문 취소
    @DeleteMapping("/cancel")
    public void cancelOrder(@RequestParam Long id) {
        orderService.cancelOrder(id);
    }
}
