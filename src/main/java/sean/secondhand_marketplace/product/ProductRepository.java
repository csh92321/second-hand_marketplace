package sean.secondhand_marketplace.product;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.secondhand_marketplace.product.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);

}

