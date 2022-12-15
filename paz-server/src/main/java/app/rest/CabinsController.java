package app.rest;

import app.exceptions.BadRequest;
import app.exceptions.PreConditionFailed;
import app.exceptions.ResourceNotFound;
import app.models.Cabin;
import app.models.Rental;
import app.repositories.CabinsRepository;
import app.repositories.RentalsRepositoryJpa;
import app.views.CustomViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/cabins")
public class CabinsController {

    @Qualifier("cabinsRepositoryJpa")
    //@Qualifier("cabinsRepositoryMock")
    @Autowired
    private CabinsRepository<Cabin> cabinsRepo;

    @Autowired
    private RentalsRepositoryJpa rentalsRepo;

    @GetMapping(path = "test", produces = "application/json")
    public List<Cabin> getTestCabins(){
        return List.of( new Cabin(30005),
                        new Cabin(30006));
    }

    @GetMapping(path = "", produces = "application/json")
    public List<Cabin> getAllCabins(@RequestParam(required = false) String type,
                                    @RequestParam(required = false) String location) {

        int paramsCount = (type != null ? 1 : 0) + (location != null ? 1 : 0);

        if (paramsCount == 0){
            // Regular request without parameters
            return this.cabinsRepo.findAll();
        } else if (paramsCount == 1){
            if (type != null){
                if (!Cabin.typeContains(type)){
                    throw new PreConditionFailed("Type=" + type + " is not a valid cabin type value");
                } else {
                    Cabin.CabinType cabinType = Cabin.CabinType.valueOf(type);
                    return cabinsRepo.findByQuery("Cabin_find_by_type", cabinType);
                }
            } else {
                return cabinsRepo.findByQuery("Cabin_find_by_location", location);
            }
        } else {
            throw new BadRequest("Illegal combination of type=, location= query parameters");
        }

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

    @GetMapping(path="{id}/rentals")
    public List<Rental> getRentals(@PathVariable int id,
                                   @RequestParam(required = false)@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
                                   @RequestParam(required = false)@DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to){

        int paramsCount = (from != null ? 1 : 0) + (to != null ? 1 : 0);
        if (paramsCount == 0){
            return rentalsRepo.findByQuery("find_rentals_by_cabinId", id);
        } else if (paramsCount == 2){
            return rentalsRepo.findByQuery("Rental_find_by_cabinId_and_period", id, from, to);
        } else {
            throw new BadRequest("Illegal combination of to=, from= query parameters");
        }
    }

    @PostMapping(path = "{id}/rentals")
    public Rental addRental(@PathVariable int id, @RequestBody Rental rental){
        Cabin cabin = cabinsRepo.findbyId(id);
        LocalDate startDate = rental.getStartDate();
        LocalDate endDate = rental.getEndDate();

        if (startDate == null){
            startDate = LocalDate.now().plusDays(1);
            rental.setStartDate(startDate);
        }

        if (endDate == null){
            endDate = startDate.plusDays(7);
            rental.setEndDate(endDate);
        }

        if (cabin == null){
            throw new PreConditionFailed("Cabin ID does not match valid cabin");
        } else if (!dateIsValid(startDate,endDate)){
            throw new PreConditionFailed("Check out date (" + startDate + ") cannot be before check in date (" + endDate + ")");
        } else if (!durationIsInWholeWeeks(startDate, endDate)){
            throw new PreConditionFailed("Period " + startDate + "to " + endDate + " is not a valid rental period.");
        }

        rental.associateCabin(cabin);
        cabin.associateRental(rental);
        return this.rentalsRepo.save(rental);
    }

    private boolean dateIsValid(LocalDate startDate, LocalDate endDate){
        return startDate.isBefore(endDate);
    }

    private boolean durationIsInWholeWeeks(LocalDate startDate, LocalDate endDate){
        Period period = Period.between(startDate, endDate);
        return period.getDays() % 7 == 0;
    }
}
