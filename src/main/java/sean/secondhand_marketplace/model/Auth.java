package sean.secondhand_marketplace.model;

import lombok.Data;
import sean.secondhand_marketplace.entity.Member;

import java.util.List;
import java.util.UUID;

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
