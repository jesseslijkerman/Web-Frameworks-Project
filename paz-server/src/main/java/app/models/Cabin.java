package app.models;

import app.views.CustomViews;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

enum Type {
    BeachGear,
    SmallDayTime,
    SmallLodge,
    LargeLodge,
    FamilyLodge
}

@Entity
@NamedQuery(name="find_all_cabins", query="select c from Cabin c")
public class Cabin {
    @Id
    @GeneratedValue
    @JsonView(CustomViews.Summary.class)
    private int id;
    @JsonView(CustomViews.Summary.class)
    private Type type;
    private String location;
    @JsonView(CustomViews.Summary.class)
    private String description;
    private String image;
    private double pricePerWeek;
    @JsonView(CustomViews.Summary.class)
    private int numAvailable;
    @OneToMany
    private List<Rental> rentals = new ArrayList<>();

    protected Cabin(){

    }

    public Cabin(Type type, String location, String description, String image, double pricePerWeek, int numAvailable) {
        this.type = type;
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
            case 0 -> this.type = Type.BeachGear;
            case 1 -> this.type = Type.SmallDayTime;
            case 2 -> this.type = Type.SmallLodge;
            case 3 -> this.type = Type.LargeLodge;
            case 4 -> this.type = Type.FamilyLodge;
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

        if (this.type == Type.BeachGear) {
            description = "";
        } else {
            description = switch (descriptionSelector) {
                case 0 -> "Colorful " + type + " with a great view.";
                case 1 -> "This " + type + " in " + location + " is a great place to relax.";
                case 2 -> "Spacy " + type + " on the beach of " + location + ".";
                case 3 -> "Comfortable " + type + ", comes with a fridge.";
                case 4 -> type + " in " + location + " where dreams come true.";
                case 5 -> "Modern " + type + " where you can enjoy the " + location + " beach.";
                default -> description;
            };
        }

        if (type == Type.BeachGear) {
            switch (Cabin.getRandomInt(3)) {
                case 0 -> pricePerWeek = 100;
                case 1 -> pricePerWeek = 120;
                case 2 -> pricePerWeek = 150;
            }
        } else if (type == Type.SmallDayTime) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 300;
                case 1 -> 370;
                case 2 -> 410;
                default -> pricePerWeek;
            };
        } else if (type == Type.SmallLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 400;
                case 1 -> 450;
                case 2 -> 500;
                default -> pricePerWeek;
            };
        } else if (type == Type.LargeLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 750;
                case 1 -> 1025;
                case 2 -> 850;
                default -> pricePerWeek;
            };
        } else if (type == Type.FamilyLodge) {
            pricePerWeek = switch (Cabin.getRandomInt(3)) {
                case 0 -> 1000;
                case 1 -> 1125;
                case 2 -> 1500;
                default -> pricePerWeek;
            };
        }
    }

    private boolean associateReview(Rental rental){
        for (Rental value : rentals) {
            if (value == rental) {
                return false;
            }
        }
        this.rentals.add(rental);
        return true;
    }

    public boolean disassociateReview(Rental rental){
        for (Rental value : rentals) {
            if (value == rental) {
                this.rentals.remove(rental);
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

    public Type getType() {
        return type;
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
                ", type=" + type +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", pricePerWeek=" + pricePerWeek +
                ", numAvailable=" + numAvailable +
                '}';
    }
}
