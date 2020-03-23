package lab.example.demo.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "subscriptions")
@Data
public class Subscription {

    @Id
    private String id = UUID.randomUUID().toString();
    @DBRef
    public Event event;
    @Indexed
    public String email;
    public LocalDateTime timeOfRegistr;


}





