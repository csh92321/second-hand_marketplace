/*
    by 전성환
    주문 등록을 위한 모델.
 */

package sean.secondhand_marketplace.model;

import lombok.*;
import sean.secondhand_marketplace.entity.Orders;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;

    private String consumer;
    private Long consumerId;
    private String seller;
    private Long sellerId;
    private String productName;
    private Long productId;

    public static OrderDto from(Orders order) {
        return OrderDto.builder()
                .consumer(order.getConsumer())
                .consumerId(order.getConsumerId())
                .sellerId(order.getSellerId())
                .productId(order.getProductId())
                .seller(order.getSeller())
                .productName(order.getProductName())
                .build();
    }
}
