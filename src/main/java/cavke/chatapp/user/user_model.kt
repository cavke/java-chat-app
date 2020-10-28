package cavke.chatapp.user

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "ca_user")
data class UserEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NotNull
        @Column(length = 255)
        val username: String,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotNull
        @Column(length = 255)
        val password: String,

        @NotNull
        @Column(length = 255)
        val email: String,

        @NotNull
        @Column
        val disabled: Boolean = false
) {
    constructor(username: String, password: String, email: String) :
            this(0, username, password, email, false)
}