package cavke.chatapp.chat;

import cavke.chatapp.user.UserEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import org.jetbrains.annotations.NotNull
import java.sql.Timestamp
import javax.persistence.*

enum class ChatType {
    USER, SYSTEM
}

@Entity
@Table(name = "chat")
data class ChatEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @NotNull
        @Column(length = 128, nullable = false)
        var name: String,

        @NotNull
        @Column(length = 128, nullable = false)
        @Enumerated(EnumType.STRING)
        var type: ChatType,

        @NotNull
        @ManyToOne
        @JoinColumn(name = "created_by", nullable = false)
        var createdBy: UserEntity,

        @NotNull
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp
) {
}

@Entity
@Table(name = "chat_member")
data class ChatMember(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
) {
}

@Entity
@Table(name = "message")
data class MessageEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @JsonIgnore
        @NotNull
        @ManyToOne
        @JoinColumn(name = "chat", nullable = false)
        var chat: ChatEntity,

        @JsonIgnore
        @NotNull
        @ManyToOne
        @JoinColumn(name = "created_by", nullable = false)
        var createdBy: UserEntity,

        @NotNull
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp,

        @NotNull
        @Column
        var text: String
) {
        constructor(chat: ChatEntity, createdBy: UserEntity, createdAt: Timestamp, text: String) :
                this (null, chat, createdBy, createdAt, text)
}
