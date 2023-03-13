package core.ics.repository;

import core.ics.model.Card;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardRepository implements PanacheRepositoryBase<Card, Long> {
}
