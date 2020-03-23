package lab.example.demo.repositry;

import lab.example.demo.model.Event;
import lab.example.demo.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
    public Iterable<Subscription> findSubscriptionsByEmail(String email);
    public Iterable<Subscription> findAll();
    public Iterable<Subscription> deleteSubscriptionByIdAndEmail(String id, String email);
}
