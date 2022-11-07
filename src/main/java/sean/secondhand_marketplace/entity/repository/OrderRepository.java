package sean.secondhand_marketplace.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sean.secondhand_marketplace.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Transactional
    void deleteAllById(Long id);

}

