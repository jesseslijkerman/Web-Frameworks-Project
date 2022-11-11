package app.models;

import com.fasterxml.jackson.annotation.JsonFilter;

enum Type {
    BeachGear,
    SmallDayTime,
    SmallLodge,
    LargeLodge,
    FamilyLodge
}

// @JsonFilter("CabinFilter")
public class Cabin {
    private int id;
    private Type type;
    private String location;
    private String description;
    private String image;
    private double pricePerWeek;
    private int numAvailable;

    protected Cabin(){

    };

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
            case 0 -> this.image = "../assets/cabins/WFW_Random0.jpg";
            case 1 -> this.image = "../assets/cabins/WFW_Random1.jpg";
            case 2 -> this.image = "../assets/cabins/WFW_Random2.jpg";
            case 3 -> this.image = "../assets/cabins/WFW_Random3.jpg";
            case 4 -> this.image = "../assets/cabins/WFW_Random4.jpg";
            case 5 -> this.image = "../assets/cabins/WFW_Random5.jpg";
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

    private static int getRandomInt(int max){
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
