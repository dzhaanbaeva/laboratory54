package lab.example.demo.dto;

import lab.example.demo.model.Event;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {
    public static EventDTO from(Event event) {

        return builder()
                .id(event.getId())
                .time(event.getTime())
                .name(event.getName())
                .description(event.getDescription())
                .build();
    }

    @Id
    public String id;
    public LocalDateTime time;
    public String name;
    public String description;

}


