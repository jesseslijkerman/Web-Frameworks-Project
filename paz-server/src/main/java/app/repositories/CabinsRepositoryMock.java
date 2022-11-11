package app.repositories;

import app.models.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CabinsRepositoryMock implements CabinsRepository{

    private int uniqueId = 50000;
    private ArrayList<Cabin> cabins = new ArrayList<>();

    public CabinsRepositoryMock() {
        for (int i = 0; i < 6; i++) {
            // this.cabins[i] = createSampleCabin(generateUniqueId());
            this.cabins.add(createSampleCabin(generateUniqueId()));
        }
    }

    public static Cabin createSampleCabin(int id){
        return new Cabin(id);
    }

    public int generateUniqueId(){
        return this.uniqueId = this.uniqueId + 1;
    }

    @Override
    public List<Cabin> findAll() {
        return this.cabins;
    }

    @Override
    public Cabin findbyId(int id) {
        for (Cabin cabin : cabins) {
            if (cabin.getId() == id) {
                return cabin;
            }
        }
        return null;
    }

    @Override
    public Cabin save(Cabin cabin) {
        Cabin selectedCabin = findbyId(cabin.getId());
        if (cabin.getId() == 0){
            cabin.setId(generateUniqueId());
            cabins.add(cabin);
        } else if (selectedCabin == null){
            cabins.add(cabin);
        } else {
            cabins.set(cabins.indexOf(selectedCabin), cabin);
        }
        return findbyId(cabin.getId());
    }

    @Override
    public Cabin deleteById(int id) {
        Cabin cabin = findbyId(id);
        cabins.remove(cabin);
        return cabin;
    }


}

