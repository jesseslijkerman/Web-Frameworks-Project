import {Type} from "@/models/type";

export class Cabin {
    id;
    type;
    location;
    description;
    image;
    pricePerWeek;
    numAvailable;

    constructor(id, type, location, description, image, pricePerWeek, numAvailable) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.description = description;
        this.image = image;
        this.pricePerWeek = pricePerWeek;
        this.numAvailable = numAvailable;
    }

    static getRandomInt(max){
        return Math.floor(Math.random() * max);
    }

    static createSampleCabin(){
        let type;
        let location;
        let description;

        let typeSelector = Cabin.getRandomInt(5);
        let locationSelector = Cabin.getRandomInt(6);
        let descriptionSelector = Cabin.getRandomInt(6);
        let numAvailable = Cabin.getRandomInt(20);

        switch (typeSelector){
            case 0:
                type = Type.BeachGear.name
                break;
            case 1:
                type = Type.SmallDayTime.name
                break;
            case 2:
                type = Type.SmallLodge.name
                break;
            case 3:
                type = Type.LargeLodge.name
                break;
            case 4:
                type = Type.FamilyLodge.name
                break;
        }

        switch (locationSelector){
            case 0:
                location = "Egmond aan Zee"
                break;
            case 1:
                location = "Wijk aan Zee"
                break;
            case 2:
                location = "Katwijk"
                break;
            case 3:
                location = "Zandvoort"
                break;
            case 4:
                location = "Zoutelande"
                break;
            case 5:
                location = "De Panne"
                break;
        }

        if (type === Type.BeachGear.name){
            description = ""
        } else {
            switch (descriptionSelector){
                case 0:
                    description = "Colorful " + type + " with a great view."
                    break;
                case 1:
                    description = "This " + type + " in " + location + "is a great place to relax."
                    break;
                case 2:
                    description = "Spacy " + type + " on the beach of " + location + "."
                    break;
                case 3:
                    description = "Comfortable " + type + ", comes with a fridge."
                    break;
                case 4:
                    description = type + " in " + location + " where dreams come true."
                    break;
                case 5:
                    description = "Modern " + type + " where you can enjoy the " + location + " beach."
                    break;
            }
        }


        return new Cabin(0, type, location, description, );
    }
}