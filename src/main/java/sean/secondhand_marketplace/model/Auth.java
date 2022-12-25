/*
    by 전성환
    로그인, 로그아웃을 위한 모델.
 */

package sean.secondhand_marketplace.model;

import lombok.Data;
import sean.secondhand_marketplace.entity.Member;

import java.util.List;

public class Auth {

    @Data
    public static class SignIn {
        private String username;
        private String password;
    }

    @Data
    public static class SignUp {
        private String username;
        private String password;
        private String email;
        private List<String> roles;

        public Member toEntity(String uuid) {
            return Member.builder()
                    .username(this.username)
                    .password(this.password)
                    .roles(this.roles)
                    .email(this.email)
                    .emailAuthYn(false)
                    .emailAuthKey(uuid)
                    .build();
        }
    }
}
