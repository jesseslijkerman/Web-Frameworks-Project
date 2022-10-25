package app.rest;

import app.models.Cabin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabinsController {

    @GetMapping("/cabins/test")
    public List<Cabin> getTestCabins(){
        return List.of( new Cabin(30005),
                        new Cabin(30006));
    }

    @GetMapping("/cabin")
    public Cabin getTestCabin(){
        return Cabin.createSampleCabin(30009);
    }
}
