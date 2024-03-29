import {Cabin} from "@/models/cabin";

export class CabinsAdaptor{
    resourcesUrl;
    constructor(resourceUrl) {
        this.resourcesUrl = resourceUrl;
        console.log("Created CabinsAdaptor for " + resourceUrl);
    }

    async fetchJson(url, options = null){
        let response = await fetch(url, options);
        if (response.ok){
            return await response.json();
        } else {
            // response body provides the http-error information
            console.log(response, !response.bodyUsed ? await response.text() : "");
            return null;
        }
    }

    async asyncFindAll(){
        console.log("CabinsAdaptor.asyncFindAll()...")
        const cabins = await this.fetchJson(this.resourcesUrl);
        return cabins?.map(s => Cabin.copyConstructor(s))
    }

    async asyncFindById(id){
        console.log("CabinsAdaptor.asyncFindById()...")
        const cabin = await this.fetchJson(this.resourcesUrl + "/" + id);
        return Cabin.copyConstructor(cabin);
    }

    async asyncSave(cabin) {
        console.log("CabinsAdaptor.asyncSave()...")
        const selectedCabin = await this.fetchJson(this.resourcesUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: cabin
        })
        return Cabin.copyConstructor(selectedCabin);
    }

    async asyncDeleteById(id) {
        console.log("CabinsAdaptor.asyncDeleteById()...");
        const cabin = this.fetchJson(this.resourcesUrl + "/" + id, {
            method: "DELETE"
        });
        return Cabin.copyConstructor(cabin);
    }
}