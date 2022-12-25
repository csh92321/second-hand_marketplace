/*
    by 전성환
    상품 등록을 위한 모델.
 */

package sean.secondhand_marketplace.model;

import lombok.*;
import sean.secondhand_marketplace.entity.Product;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String productName;
    private String seller;
    private Long sellerId;
    private String type;
    private int price;
    private String state;
    private String context;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .seller(product.getSeller())
                .sellerId(product.getSellerId())
                .productName(product.getProductName())
                .type(product.getType())
                .price(product.getPrice())
                .state(product.getState())
                .context(product.getContext())
                .build();
    }
}
