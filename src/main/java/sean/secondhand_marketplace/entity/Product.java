/*
    by 전성환
    상품 목록 데이터 베이스.
 */

package sean.secondhand_marketplace.entity;

import lombok.*;
import sean.secondhand_marketplace.model.AddProductForm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String seller;
    private Long sellerId;
    private String type;
    private int price;
    private String state;
    private String context;
    private LocalDateTime regDt;

    //빌드 생성
    public static Product of(String seller, Long sellerId, AddProductForm form) {
        return Product.builder()
                .seller(seller)
                .sellerId(sellerId)
                .productName(form.getProductName())
                .type(form.getType())
                .price(form.getPrice())
                .state(form.getState())
                .context(form.getContext())
                .regDt(LocalDateTime.now())
                .build();
    }


}
