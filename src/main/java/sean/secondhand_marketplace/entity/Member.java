/*
    by 전성환
    회원 목록 데이터 베이스.
 */

package sean.secondhand_marketplace.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime regDt;

    //이메일 인증 여부
    private boolean emailAuthYn;
    //이메일 인증이 이루어진 날짜
    private LocalDateTime emailAuthDt;
    //이메일 인증을 위한 키
    private String emailAuthKey;

    //회원의 접근 권한.
    @ElementCollection
    private List<String> roles;

    //인증 받은 사용자 조회
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    //계정의 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //계정의 잠금 여부
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    //계정의 패스워드 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //계정의 사용 가능 여부
    @Override
    public boolean isEnabled() {
        return false;
    }
}
