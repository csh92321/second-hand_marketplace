package sean.secondhand_marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductForm {

    private String productName;
    private String seller;
    private String type;
    private int price;
    private String state;
    private String context;
}
