/*
    by 전성환
    멤버 데이터 베이스와 관련된 레파지토리.
 */

package sean.secondhand_marketplace.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sean.secondhand_marketplace.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    Long findIdByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Member> findByEmailAuthKey(String emailAuthKey);

}

