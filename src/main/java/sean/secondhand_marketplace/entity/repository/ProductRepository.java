package sean.secondhand_marketplace.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sean.secondhand_marketplace.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Transactional
    void deleteAllById(Long id);

    Optional<Product> findByProductNameContains(String productName);

}

