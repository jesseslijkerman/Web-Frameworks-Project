export class Type{
    static BeachGear = new Type("Beach Gear")
    static SmallDayTime = new Type("Small Day Time")
    static SmallLodge = new Type("Small Lodge")
    static LargeLodge = new Type("Large Lodge")
    static FamilyLodge = new Type("Family Lodge")

    constructor(name) {
        this.name = name
    }
}