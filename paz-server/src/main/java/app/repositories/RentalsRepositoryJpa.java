package app.repositories;

import app.models.Cabin;
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

    public Rental findById(int id) {
        return entityManager.find(Rental.class, id);
    }

    public Rental save(Rental rental) {
        return entityManager.merge(rental);
    }

    public Rental deleteById(int id) {
        Rental rental = findById(id);
        entityManager.remove(rental);
        return rental;
    }

    public List<Rental> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Rental> namedQuery = entityManager.createNamedQuery(jpqlName, Rental.class);


        for (int i = 0; i < params.length; i++) {
            namedQuery.setParameter(i+1, params[i]);
        }

        return namedQuery.getResultList();
    }
}
