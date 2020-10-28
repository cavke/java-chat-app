package cavke.chatapp.chat

import org.jetbrains.annotations.NotNull

data class CreateMessageRequest(
        @NotNull
        val createdBy: Long,
        @NotNull
        val chatId: Long,
        @NotNull
        val text: String
)