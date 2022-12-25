/*
    by 전성환
    회원 서비스에 관련된 기능.
 */

package sean.secondhand_marketplace.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sean.secondhand_marketplace.components.MailComponents;
import sean.secondhand_marketplace.model.Auth;
import sean.secondhand_marketplace.entity.Member;
import sean.secondhand_marketplace.entity.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

    //유저 이름으로 유저 찾기
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("couldn't find user - > " + username));
    }

    //회원가입
    public Member register(Auth.SignUp member) {
        boolean exists = this.memberRepository.existsByUsername(member.getUsername());
        if (exists) {
            throw new RuntimeException("이미 사용 중인 아이디 입니다.");
        }

        String uuid = UUID.randomUUID().toString();

        member.setPassword(this.passwordEncoder.encode(member.getPassword()));
        var result = this.memberRepository.save(member.toEntity(uuid));

        String subject = ("안녕하세요 세컨드 핸드입니다.");
        String text = ("<p>회원가입을 축하드립니다. 아래 링크를 클릭하셔서 가입을 완료하세요</p>"
                + "<div><a href='http://localhost:8080/auth/email?id=" + uuid + "'> 인증하기 </a></div>");

        mailComponents.sendMail(member.getEmail(), subject, text);

        return result;
    }

    //로그인
    public Member authenticate(Auth.SignIn member) {
        var user = this.memberRepository.findByUsername(member.getUsername())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 ID 입니다"));
        if (!this.passwordEncoder.matches(member.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

    //이메일 인증을 실행
    public boolean emailAuth(String uuid) {

        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);

        if (!optionalMember.isPresent()) {
            return false;
        }
        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
