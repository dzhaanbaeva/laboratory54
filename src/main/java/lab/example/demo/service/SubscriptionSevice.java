package lab.example.demo.service;


import lab.example.demo.dto.SubscriptionDTO;
import lab.example.demo.exception.ResourceNotFoundException;
import lab.example.demo.model.Event;
import lab.example.demo.model.Subscription;
import lab.example.demo.repositry.EventRepository;
import lab.example.demo.repositry.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionSevice {
    private final SubscriptionRepository subscriptionRepository;
    private final EventRepository eventRepository;


    public SubscriptionSevice(SubscriptionRepository subscriptionRepository, EventRepository eventRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.eventRepository = eventRepository;
    }

    public Object addSubscription(SubscriptionDTO subscriptionData) {

        var dateInner = subscriptionData.getTimeOfRegistr();
        var dateNow = LocalDateTime.now();

        if (dateInner.isAfter(dateNow)) {
           var subscription = Subscription.builder()
                    .id(subscriptionData.getId())
                    .event(Event.builder().id(subscriptionData.getEventId()).build())
                    .email(subscriptionData.getEmail())
                    .timeOfRegistr(subscriptionData.getTimeOfRegistr())
                    .build();
            subscriptionRepository.save(subscription);
            return SubscriptionDTO.from(subscription);
        } else {
            return new ResourceNotFoundException("You cannot subscribe to this date");
        }
    }
    public Iterable<Subscription> findSubscription(String email) {
        return subscriptionRepository.findSubscriptionsByEmail(email);
    }
    public Iterable<Subscription> findSubscrip() {
        return subscriptionRepository.findAll();
    }

    public boolean deleteSub(String subscriptionId, String email) {
        //TODO recalculate movie rating before delete
        subscriptionRepository.deleteSubscriptionByIdAndEmail(subscriptionId, email);
        return true;
    }
}
