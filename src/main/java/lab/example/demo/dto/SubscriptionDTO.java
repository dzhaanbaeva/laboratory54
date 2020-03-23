package lab.example.demo.dto;

import lab.example.demo.model.Subscription;
import lombok.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;


@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDTO {

             public static SubscriptionDTO from(Subscription subscription) {
                 return builder()
                         .id(subscription.getId())
                         .eventId(subscription.getEvent().getId())
                         .email(subscription.getEmail())
                         .timeOfRegistr(subscription.getTimeOfRegistr())
                         .build();
             }


    @Id
    public String id;
    public String eventId;
    private String email;
    public LocalDateTime timeOfRegistr;
    }


