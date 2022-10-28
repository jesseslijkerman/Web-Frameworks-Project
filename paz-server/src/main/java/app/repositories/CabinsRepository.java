package app.repositories;

import app.models.Cabin;

import java.util.List;

public interface CabinsRepository {
    List<Cabin> findAll();
}
