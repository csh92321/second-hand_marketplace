package sean.secondhand_marketplace.product.entity;

import lombok.*;
import sean.secondhand_marketplace.product.AddProductForm;

import javax.persistence.*;

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
    private String type;
    private int price;
    private String state;
    private String context;

    public static Product of(String seller, AddProductForm form) {
        return Product.builder()
                .seller(seller)
                .productName(form.getProductName())
                .type(form.getType())
                .price(form.getPrice())
                .state(form.getState())
                .context(form.getContext())
                .build();
    }



}
