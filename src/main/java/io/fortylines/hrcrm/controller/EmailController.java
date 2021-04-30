package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateMailDto;
import io.fortylines.hrcrm.dto.CreateMailSendingDto;
import io.fortylines.hrcrm.dto.ReadEmailDto;
import io.fortylines.hrcrm.dtoService.EmailDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/emails")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR')")
public class EmailController {

    private final EmailDtoService emailDtoService;

    @Autowired
    public EmailController(EmailDtoService emailDtoService) {
        this.emailDtoService = emailDtoService;
    }

    @GetMapping
    public List<ReadEmailDto> getAllMessages() throws MessagingException, IOException {
        return emailDtoService.getAllMessages();
    }

    @GetMapping("/unread_messages")
    public List<ReadEmailDto> getUnreadMessages() throws IOException, MessagingException {
        return emailDtoService.getUnreadMessages();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestParam String fileName) throws MessagingException {
        emailDtoService.delete(id, fileName);
    }

    @PostMapping("/mail_sending")
    public void mailSending(@RequestBody CreateMailSendingDto createMailSendingDto) throws MessagingException {
        emailDtoService.mailSending(createMailSendingDto);
    }

    @PostMapping("/send_email")
    public void sendMessage(@RequestBody CreateMailDto createMailDto) throws MessagingException {
        emailDtoService.sendMessage(createMailDto);
    }
}
