package lab.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Document(collection = "events")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Event {

        @Id
        @Builder.Default
        private String id = UUID.randomUUID().toString();
        public  LocalDateTime time;
        @Indexed
        public String name;
        public String description;
    }


