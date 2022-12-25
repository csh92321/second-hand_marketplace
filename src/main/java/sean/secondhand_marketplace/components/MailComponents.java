/*
    by 전성환
    회원 가입시 인증을 위한 메일을 보내는 기능을 구현.
 */


package sean.secondhand_marketplace.components;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class MailComponents {

    private final JavaMailSender javaMailSender;

    public boolean sendMail(String email, String subject, String text) {

        boolean result = false;

        MimeMessagePreparator msg = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);

            }
        };
        try {
            javaMailSender.send(msg);
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
