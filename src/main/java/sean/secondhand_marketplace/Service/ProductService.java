/*
    by 전성환
    상품 서비스에 관련된 기능.
 */

package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.entity.repository.MemberRepository;
import sean.secondhand_marketplace.model.AddProductForm;
import sean.secondhand_marketplace.entity.repository.ProductRepository;
import sean.secondhand_marketplace.entity.Product;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    //상품을 등록
    public Product addProduct(String seller, AddProductForm form) {
        Long sellerId = memberRepository.findIdByUsername(seller);
        return productRepository.save(Product.of(seller, sellerId, form));
    }

    //상품 검색
    public Optional<Product> searchProduct(String productName) {
        return productRepository.findByProductNameContains(productName);
    }

    //상품 정보 수정
    public Product updateProduct(Long id, AddProductForm form) {

        Product product = productRepository.findById(id).orElseThrow();

        product.setProductName(form.getProductName());
        product.setContext(form.getContext());
        product.setPrice(form.getPrice());
        product.setState(form.getState());
        product.setType(form.getType());

        return productRepository.save(product);

    }

    //상품 삭제
    public void deleteProduct(Long id) {
        productRepository.deleteAllById(id);
    }


}
