export class Cabin{
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

    }
}