package sean.secondhand_marketplace.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.secondhand_marketplace.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    boolean existsByUsername(String username);
}

