package sean.secondhand_marketplace.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.secondhand_marketplace.persist.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}

