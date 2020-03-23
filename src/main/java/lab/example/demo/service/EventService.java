package lab.example.demo.service;

import lab.example.demo.dto.EventDTO;
import lab.example.demo.model.Event;
import lab.example.demo.repositry.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;



    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public EventDTO addEvent(EventDTO eventData) {

        var event = Event.builder()
                .time(eventData.getTime())
                .name(eventData.getName())
                .description(eventData.getDescription())
                .build();

        eventRepository.save(event);
        return EventDTO.from(event);
    }

    public Iterable<Event> findMovies() {
       return eventRepository.findAll();
    }
}
