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
        return cabin?.map(s => Cabin.copyConstructor(s))
    }
}