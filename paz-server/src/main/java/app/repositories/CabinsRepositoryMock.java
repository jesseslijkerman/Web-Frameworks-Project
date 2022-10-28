package app.repositories;

import app.models.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class CabinsRepositoryMock implements CabinsRepository{

    private int uniqueId = 50000;
    private Cabin[] cabins;

    public CabinsRepositoryMock() {
        this.cabins = new Cabin[6];
        for (int i = 0; i < cabins.length; i++) {
            this.cabins[i] = createSampleCabin(generateUniqueId());
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
        return Arrays.asList(this.cabins);
    }


}
