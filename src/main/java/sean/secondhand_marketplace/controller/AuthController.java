package sean.secondhand_marketplace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sean.secondhand_marketplace.Service.MemberService;
import sean.secondhand_marketplace.components.MailComponents;
import sean.secondhand_marketplace.model.Auth;
import sean.secondhand_marketplace.security.TokenProvider;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;
    private final TokenProvider tokenProvider;
    private final MailComponents mailComponents;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody Auth.SignUp request) {
        var result = this.memberService.register(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody Auth.SignIn request) {
        var member = this.memberService.authenticate(request);
        var token = this.tokenProvider.generateToken(member.getUsername(), member.getRoles());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/email")
    public ResponseEntity<?> emailAuth(HttpServletRequest request) {

        String uuid = request.getParameter("id");

        var result = memberService.emailAuth(uuid);

        return ResponseEntity.ok(result);
    }
}
