/*
    by 전성환
    주문 목록 데이터 베이스.
 */

package sean.secondhand_marketplace.entity;

import lombok.*;
import sean.secondhand_marketplace.model.AddOrderForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //정확한 구분을 위해 ID 항목 추가
    private String consumer;
    private Long consumerId;
    private String seller;
    private Long sellerId;
    private String productName;
    private Long productId;

    //주문 빌드 생성
    public static Orders of(String consumer, Long sellerId, Long consumerId, Long productId, AddOrderForm form) {
        return Orders.builder()
                .consumer(consumer)
                .consumerId(consumerId)
                .seller(form.getSeller())
                .sellerId(sellerId)
                .productName(form.getProductName())
                .productId(productId)
                .build();
    }


}
