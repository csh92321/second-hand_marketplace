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

    private String consumer;
    private String seller;
    private String productName;

    public static Orders of(String consumer, AddOrderForm form) {
        return Orders.builder()
                .consumer(consumer)
                .seller(form.getSeller())
                .productName(form.getProductName())
                .build();
    }



}
