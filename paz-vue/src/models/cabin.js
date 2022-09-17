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

    static createSampleCabin(){
        let typeSelector = Math.random() * 5;
        let locationSelector = Math.random() * 6;
        let descriptionSelector = Math.random() * 6;
    }
}