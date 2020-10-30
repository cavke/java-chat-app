package cavke.chatapp.chat;

import cavke.chatapp.user.UserEntity;
import cavke.chatapp.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/messages")
    public List<MessageEntity> getAllMessages() {
        // TODO implement pagination
        return messageRepository.findAll();
    }

    @PostMapping("/messages")
    public MessageEntity createMessage(@RequestBody CreateMessageRequest request) {
        log.debug("createMessage: {}", request);
        UserEntity u = userRepository.findById(request.getCreatedBy()).orElseThrow(() -> new RuntimeException("Unknown user"));
        ChatEntity c = chatRepository.findById(request.getChatId()).orElseThrow(() -> new RuntimeException("Unknown chat"));
        MessageEntity message = new MessageEntity(c, u, new Timestamp(System.currentTimeMillis()), request.getText());
        
        return messageRepository.save(message);
    }

    // TODO implement other CRUD messages
}
