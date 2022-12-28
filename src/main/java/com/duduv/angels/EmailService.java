package com.duduv.angels;

import com.duduv.angels.model.AngelConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final AngelConfig angelConfig;
    private final Configuration configuration;


    @SneakyThrows
    public void sendSimpleMessage(String to, String subject, String mailTemplate, Map<String, Object> context) {

        if (angelConfig.getSendMailOnlyTo() == null || to.equals(angelConfig.getSendMailOnlyTo())) {

            String msg = geContentFromTemplate(mailTemplate, context);

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());


            helper.setFrom(angelConfig.getFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(msg, true);
            helper.addInline("logo.png", new ClassPathResource("logo.png"));
            emailSender.send(message);
        }

    }

    @SneakyThrows
    private String geContentFromTemplate(String templateName, Map<String, Object> model) {
        StringBuilder content = new StringBuilder();
        Template template = configuration.getTemplate(templateName);
        content.append(FreeMarkerTemplateUtils.processTemplateIntoString(template, model));
        return content.toString();
    }

}
