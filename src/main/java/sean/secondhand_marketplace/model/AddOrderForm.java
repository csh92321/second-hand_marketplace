/*
    by 전성환
    주문 등록을 위한 폼.
 */

package sean.secondhand_marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderForm {

    private String seller;
    private String productName;

}
