package lab.example.demo.repositry;

import lab.example.demo.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, String> {
    public Iterable<Event> findAll();


}
