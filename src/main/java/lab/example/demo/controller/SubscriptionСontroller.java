package lab.example.demo.controller;

import lab.example.demo.dto.SubscriptionDTO;
import lab.example.demo.model.Subscription;
import lab.example.demo.service.SubscriptionSevice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscriptionСontroller {

        private final SubscriptionSevice subscriptionSevice;

    public SubscriptionСontroller(SubscriptionSevice subscriptionSevice) {
        this.subscriptionSevice = subscriptionSevice;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SubscriptionDTO addSub(@RequestBody SubscriptionDTO subData) {
        return (SubscriptionDTO) subscriptionSevice.addSubscription(subData);
    }

    @GetMapping
    public Iterable<Subscription> getSubscription() {
        return subscriptionSevice.findSubscrip();
    }

    @GetMapping("/{email}")
    public Iterable<Subscription> findSubscription(@PathVariable("email") String email) {
        return subscriptionSevice.findSubscription(email);
    }

    @DeleteMapping("/{id}/{email}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String id,
                                                   @PathVariable String email) {
        if (subscriptionSevice.deleteSub(id, email))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }



}
