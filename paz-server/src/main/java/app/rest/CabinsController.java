package app.rest;

import app.models.Cabin;
import app.repositories.CabinsRepositoryMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabinsController {

    CabinsRepositoryMock cabinsRepo = new CabinsRepositoryMock();

    @GetMapping("/cabins/test")
    public List<Cabin> getTestCabins(){
        return List.of( new Cabin(30005),
                        new Cabin(30006));
    }

    @GetMapping("/cabins/test2")
    public List<Cabin> getAllCabins() {
        return this.cabinsRepo.findAll();
    }

    @GetMapping("/cabin")
    public Cabin getTestCabin(){
        return Cabin.createSampleCabin(30009);
    }
}
