package app.rest;

import app.exceptions.PreConditionFailed;
import app.exceptions.ResourceNotFound;
import app.models.Cabin;
import app.repositories.CabinsRepository;
import app.repositories.CabinsRepositoryJpa;
import app.repositories.CabinsRepositoryMock;
import app.views.CustomViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cabins")
public class CabinsController {

    @Qualifier("cabinsRepositoryJpa")
    @Autowired
    private CabinsRepository cabinsRepo;

    @GetMapping(path = "test", produces = "application/json")
    public List<Cabin> getTestCabins(){
        return List.of( new Cabin(30005),
                        new Cabin(30006));
    }

    @GetMapping(path = "", produces = "application/json")
    public List<Cabin> getAllCabins() {
        return this.cabinsRepo.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Cabin findById(@PathVariable int id){
        Cabin cabin = this.cabinsRepo.findbyId(id);
        if (cabin==null){
            throw new ResourceNotFound("id-" + id);
        }
        return cabin;
    }

    @PostMapping(path = "")
    public ResponseEntity<Object> createCabin(@RequestBody Cabin cabin){
        cabinsRepo.save(cabin);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cabin.getId()).toUri();

        return ResponseEntity.created(location).body(cabin);
    }

    @PutMapping(path = "/{id}")
    public Cabin editCabin(@PathVariable int id, @RequestBody Cabin cabin){
        if (cabin.getId() != id){
            throw new PreConditionFailed("id-" + id + " doesn't match id of body");
        }

        cabinsRepo.save(cabin);
        return cabin;
    }

    @DeleteMapping(path = "/{id}")
    public Cabin deleteCabin(@PathVariable int id){
        Cabin cabin = cabinsRepo.deleteById(id);
        if (cabin==null){
            throw new ResourceNotFound("id-" + id);
        }
        return cabin;
    }

    @JsonView(CustomViews.Summary.class)
    @GetMapping(path = "summary", produces = "application/json")
    public List<Cabin> getCabinSummary(){
        return cabinsRepo.findAll();
    }
}
