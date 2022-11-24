package app.repositories;

import app.models.Cabin;

import java.util.List;

public interface CabinsRepository {

    List<Cabin> findAll();
    Cabin findbyId(int id);

    Cabin save(Cabin cabin);

    Cabin deleteById(int id);
}
