package app.rest;

import app.exceptions.ResourceNotFoundException;
import app.models.Cabin;
import app.repositories.CabinsRepositoryMock;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cabins")
public class CabinsController {

    @Autowired
    private CabinsRepositoryMock cabinsRepo;

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
            throw new ResourceNotFoundException("id-" + id);
        }
        return cabin;
    }

    @PostMapping(path = "")
    public ResponseEntity<Object> createCabin(@RequestBody Cabin cabin){
        cabinsRepo.save(cabin);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cabin.getId()).toUri();

        // .body() method??

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{id}")
    public Cabin deleteCabin(@PathVariable int id){
        Cabin cabin = cabinsRepo.deleteById(id);
        if (cabin==null){
            throw new ResourceNotFoundException("id-" + id);
        }
        return cabin;
    }

    @GetMapping(path = "summary", produces = "application/json")
    public MappingJacksonValue getCabinSummary(){
        List<Cabin> cabins = this.cabinsRepo.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("id", "type", "description", "numAvailable");

        FilterProvider filters = new SimpleFilterProvider().addFilter("CabinFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(cabins);
        mapping.setFilters(filters);
        return mapping;
    }
}
