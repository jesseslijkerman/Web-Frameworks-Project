package app.repositories;

import app.models.Cabin;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CabinsRepository {

    List<Cabin> findAll();
}
