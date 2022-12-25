/*
    by 전성환
    상품 데이터 베이스와 관련된 레파지토리.
 */

package sean.secondhand_marketplace.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sean.secondhand_marketplace.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Long findIdByProductName(String productName);

    @Transactional
    void deleteAllById(Long id);

    Optional<Product> findByProductNameContains(String productName);

}

