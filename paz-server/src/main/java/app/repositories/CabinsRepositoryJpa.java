package app.repositories;

import app.models.Cabin;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CabinsRepositoryJpa implements CabinsRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Cabin> findAll() {
        TypedQuery<Cabin> namedQuery = entityManager.createNamedQuery("find_all_cabins", Cabin.class);
        return namedQuery.getResultList();
    }

    @Override
    public Cabin findbyId(int id) {
        return entityManager.find(Cabin.class, id);
    }

    @Override
    public Cabin save(Cabin cabin) {
        return entityManager.merge(cabin);
    }

    @Override
    public Cabin deleteById(int id) {
        Cabin cabin = findbyId(id);
        entityManager.remove(cabin);
        return cabin;
    }
}


    

   