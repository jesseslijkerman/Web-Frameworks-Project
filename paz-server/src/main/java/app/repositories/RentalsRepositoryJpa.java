package app.repositories;

import app.models.Rental;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RentalsRepositoryJpa {
    @PersistenceContext
    EntityManager entityManager;

    public List<Rental> findAll() {
        TypedQuery<Rental> namedQuery = entityManager.createNamedQuery("find_all_rentals", Rental.class);
        return namedQuery.getResultList();
    }

    public Rental findbyId(int id) {
        return entityManager.find(Rental.class, id);
    }

    public Rental save(Rental rental) {
        return entityManager.merge(rental);
    }

    public Rental deleteById(int id) {
        Rental rental = findbyId(id);
        entityManager.remove(rental);
        return rental;
    }
}
