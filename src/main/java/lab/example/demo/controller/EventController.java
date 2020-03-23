package lab.example.demo.controller;

import lab.example.demo.dto.EventDTO;
import lab.example.demo.model.Event;
import lab.example.demo.service.EventService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public EventDTO addEvent(@RequestBody EventDTO movieData) {
        return eventService.addEvent(movieData);
    }

    @GetMapping
    public Iterable<Event> getEvents() {
        return eventService.findMovies();
    }


}
