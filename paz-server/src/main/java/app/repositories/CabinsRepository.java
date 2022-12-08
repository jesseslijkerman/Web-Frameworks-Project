package app.repositories;

import app.models.Cabin;

import java.util.List;

public interface CabinsRepository<E> {

    List<Cabin> findAll();

    Cabin findbyId(int id);

    Cabin save(Cabin cabin);

    Cabin deleteById(int id);

    List<E> findByQuery(String jpqlName, Object... params);
}
