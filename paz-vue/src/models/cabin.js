const Type = {
    BeachGear: "BeachGear",
    SmallDayTime: "SmallDayTime",
    SmallLodge: "SmallLodge",
    LargeLodge: "LargeLodge",
    FamilyLodge: "FamilyLodge"
}

export class Cabin {
    id;
    cabinType;
    location;
    description;
    image;
    pricePerWeek;
    numAvailable;

    constructor(id, cabinType, location, description, image, pricePerWeek, numAvailable) {
        this.id = id;
        this.cabinType = cabinType;
        this.location = location;
        this.description = description;
        this.image = image;
        this.pricePerWeek = pricePerWeek;
        this.numAvailable = numAvailable;
    }

    static getRandomInt(max){
        return Math.floor(Math.random() * max);
    }

    static createSampleCabin(pId = 0) {

        let cabinType;
        let location;
        let image;
        let description;
        let price;

        let cabinTypeSelector = Cabin.getRandomInt(5);
        let locationSelector = Cabin.getRandomInt(6);
        let imageSelector = Cabin.getRandomInt(6);
        let descriptionSelector = Cabin.getRandomInt(6);
        let numAvailable = Cabin.getRandomInt(50);

        switch (cabinTypeSelector) {
            case 0:
                cabinType = "BeachGear"
                break;
            case 1:
                cabinType = "SmallDayTime"
                break;
            case 2:
                cabinType = "SmallLodge"
                break;
            case 3:
                cabinType = "LargeLodge"
                break;
            case 4:
                cabinType = "FamilyLodge"
                break;
        }

        switch (locationSelector) {
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

        switch (imageSelector) {
            case 0:
                image = require("../assets/cabins/WFW_Random0.jpg")
                break;
            case 1:
                image = require("../assets/cabins/WFW_Random1.jpg")
                break;
            case 2:
                image = require("../assets/cabins/WFW_Random2.jpg")
                break;
            case 3:
                image = require("../assets/cabins/WFW_Random3.jpg")
                break;
            case 4:
                image = require("../assets/cabins/WFW_Random4.jpg")
                break;
            case 5:
                image = require("../assets/cabins/WFW_Random5.jpg")
                break;
        }

        if (cabinType === Type.BeachGear) {
            description = ""
        } else {
            switch (descriptionSelector) {
                case 0:
                    description = "Colorful " + cabinType + " with a great view."
                    break;
                case 1:
                    description = "This " + cabinType + " in " + location + "is a great place to relax."
                    break;
                case 2:
                    description = "Spacy " + cabinType + " on the beach of " + location + "."
                    break;
                case 3:
                    description = "Comfortable " + cabinType + ", comes with a fridge."
                    break;
                case 4:
                    description = cabinType + " in " + location + " where dreams come true."
                    break;
                case 5:
                    description = "Modern " + cabinType + " where you can enjoy the " + location + " beach."
                    break;
            }
        }

        if (cabinType === Type.BeachGear) {
            switch (Cabin.getRandomInt(3)) {
                case 0:
                    price = 100;
                    break;
                case 1:
                    price = 120;
                    break;
                case 2:
                    price = 150;
                    break;
            }
        } else if (cabinType === Type.SmallDayTime) {
            switch (Cabin.getRandomInt(3)) {
                case 0:
                    price = 300;
                    break;
                case 1:
                    price = 370;
                    break;
                case 2:
                    price = 410;
            }
        } else if (cabinType === Type.SmallLodge) {
            switch (Cabin.getRandomInt(3)) {
                case 0:
                    price = 400;
                    break;
                case 1:
                    price = 450;
                    break;
                case 2:
                    price = 500;
            }
        } else if (cabinType === Type.LargeLodge) {
            switch (Cabin.getRandomInt(3)) {
                case 0:
                    price = 750;
                    break;
                case 1:
                    price = 1025;
                    break;
                case 2:
                    price = 850;
            }
        } else if (cabinType === Type.FamilyLodge) {
            switch (Cabin.getRandomInt(3)) {
                case 0:
                    price = 1000;
                    break;
                case 1:
                    price = 1125;
                    break;
                case 2:
                    price = 1500;
            }
        }
        return new Cabin(pId, cabinType, location, description, image, price, numAvailable);
    }

    static copyConstructor(cabin){
        if (cabin == null) {
            return null
        }


        // Copies properties from selected cabin to a new cabin
        return Object.assign(new Cabin(0), cabin);
    }
}