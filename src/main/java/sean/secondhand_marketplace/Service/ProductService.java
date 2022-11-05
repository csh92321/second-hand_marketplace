package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.product.AddProductForm;
import sean.secondhand_marketplace.product.ProductRepository;
import sean.secondhand_marketplace.product.entity.Product;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(String seller, AddProductForm form) {
        return productRepository.save(Product.of(seller, form));
    }

    public Optional<Product> searchProduct(String productName) {
        return productRepository.findByProductNameContains(productName);
    }

    public Product updateProduct(Long id, AddProductForm form) {

        Product product = productRepository.findById(id).orElseThrow();

        product.setProductName(form.getProductName());
        product.setContext(form.getContext());
        product.setPrice(form.getPrice());
        product.setState(form.getState());
        product.setType(form.getType());

        return productRepository.save(product);

    }

    public void deleteProduct(Long id) {
        productRepository.deleteAllById(id);
    }


}
