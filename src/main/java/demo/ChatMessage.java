package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChatMessage {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String message;

    public ChatMessage() {
    }

    private ChatMessage(Builder builder) {
        setId(builder.id);
        setMessage(builder.message);
    }

    public static Builder newChatMessage() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static final class Builder {
        private Long id;
        private String message;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(this);
        }
    }
}
