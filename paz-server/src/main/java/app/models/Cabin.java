package app.models;

import app.views.CustomViews;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name="find_all_cabins", query="SELECT c FROM Cabin c"),
        @NamedQuery(name="Cabin_find_by_type", query = "SELECT c FROM Cabin c WHERE c.cabinType = ?1"),
        @NamedQuery(name="Cabin_find_by_location", query="SELECT c FROM Cabin c WHERE c.location = ?1")
})
@Entity
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CustomViews.Summary.class)
    private int id;
    @Enumerated(EnumType.STRING)
    @JsonView(CustomViews.Summary.class)
    private CabinType cabinType;
    private String location;
    @JsonView(CustomViews.Summary.class)
    private String description;
    private String image;
    private double pricePerWeek;
    @JsonView(CustomViews.Summary.class)
    private int numAvailable;
    @OneToMany(mappedBy = "cabin")
    @JsonManagedReference
    private List<Rental> rentals = new ArrayList<>();

    public enum CabinType {
        BeachGear,
        SmallDayTime,
        SmallLodge,
        LargeLodge,
        FamilyLodge
    }

    protected Cabin(){

    }

    public Cabin(CabinType cabinType, String location, String description, String image, double pricePerWeek, int numAvailable) {
        this.cabinType = cabinType;
        this.location = location;
        this.description = description;
        this.image = image;
        this.pricePerWeek = pricePerWeek;
        this.numAvailable = numAvailable;
    }

    public Cabin(int id){
        int typeSelector = Cabin.getRandomInt(5);
        int locationSelector = Cabin.getRandomInt(6);
        int imageSelector = Cabin.getRandomInt(6);
        int descriptionSelector = Cabin.getRandomInt(6);

        this.id = id;
        this.numAvailable = Cabin.getRandomInt(50);

        switch (typeSelector) {
            case 0 -> this.cabinType = CabinType.BeachGear;
            case 1 -> this.cabinType = CabinType.SmallDayTime;
            case 2 -> this.cabinType = CabinType.SmallLodge;
            case 3 -> this.cabinType = CabinType.LargeLodge;
            case 4 -> this.cabinType = CabinType.FamilyLodge;
        }

        switch (locationSelector) {
            case 0 -> this.location = "Egmond aan Zee";
            case 1 -> this.location = "Wijk aan Zee";
            case 2 -> this.location = "Katwijk";
            case 3 -> this.location = "Zandvoort";
            case 4 -> this.location = "Zoutelande";
            case 5 -> this.location = "De Panne";
        }

        switch (imageSelector) {
            case 0 -> this.image = "/img/WFW_Random0.d811a977.jpg";
            case 1 -> this.image = "/img/WFW_Random1.b4cfae01.jpg";
            case 2 -> this.image = "/img/WFW_Random2.fddc4344.jpg";
            case 3 -> this.image = "/img/WFW_Random3.631f4ca9.jpg";
            case 4 -> this.image = "/img/WFW_Random4.f1f7f6db.jpg";
            case 5 -> this.image = "/img/WFW_Random5.f52e03ea.jpg";
        }

        if (this.cabinType == CabinType.BeachGear) {
            description = "";
        } else {
            description = switch (descriptionSelector) {
                case 0 -> "Colorful " + cabinType + " with a great view.";
                case 1 -> "This " + cabinType + " in " + location + " is a great place to relax.";
                case 2 -> "Spacy " + cabinType + " on the beach of " + location + ".";
                case 3 -> "Comfortable " + cabinType + ", comes with a fridge.";
                case 4 -> cabinType + " in " + location + " where dreams come true.";
                case 5 -> "Modern " + cabinType + " where you can enjoy the " + location + " beach.";
                default -> description;
            };
        }

        if (cabinType == CabinType.BeachGear) {
            switch (Cabin.getRandomInt(3)) {
                case 0 -> pricePerWeek = 100;
                case 1 -> pricePerWeek = 120;
                case 2 -> pricePerWeek = 150;
            }
        } else if (cabinType == CabinType.SmallDayTime) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 300;
                case 1 -> 370;
                case 2 -> 410;
                default -> pricePerWeek;
            };
        } else if (cabinType == CabinType.SmallLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 400;
                case 1 -> 450;
                case 2 -> 500;
                default -> pricePerWeek;
            };
        } else if (cabinType == CabinType.LargeLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 750;
                case 1 -> 1025;
                case 2 -> 850;
                default -> pricePerWeek;
            };
        } else if (cabinType == CabinType.FamilyLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 1000;
                case 1 -> 1125;
                case 2 -> 1500;
                default -> pricePerWeek;
            };
        }
    }

    public boolean associateRental(Rental rental){
//        for (Rental value : rentals) {
//            if (value == rental) {
//                return false;
//            }
//        }
        this.rentals.add(rental);
        return true;
    }

    public boolean disassociateRental(Rental rental){
        for (Rental value : rentals) {
            if (value == rental) {
                this.rentals.remove(rental);
                return true;
            }
        }
        return false;
    }

    public static boolean typeContains(String type){
        for (CabinType t : CabinType.values()){
            if (t.name().equals(type)){
                return true;
            }
        }
        return false;
    }

    public static int getRandomInt(int max){
        return (int) Math.floor(Math.random() * max);
    }

    public int getId() {
        return id;
    }

    public CabinType getCabinType() {
        return cabinType;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getPricePerWeek() {
        return pricePerWeek;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cabin{" +
                "id=" + id +
                ", cabinType=" + cabinType +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", pricePerWeek=" + pricePerWeek +
                ", numAvailable=" + numAvailable +
                '}';
    }
}
