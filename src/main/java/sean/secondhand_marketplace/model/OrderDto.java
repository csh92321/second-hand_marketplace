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
    private String seller;
    private String productName;

    public static OrderDto from(Orders order) {
        return OrderDto.builder()
                .consumer(order.getConsumer())
                .seller(order.getSeller())
                .productName(order.getProductName())
                .build();
    }
}
