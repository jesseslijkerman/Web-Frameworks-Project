export class SessionSbService {
    BROWSER_STORAGE_ITEM_NAME;
    RESOURCES_URL;

    constructor(resourceUrl, browserStorageItemName) {
        this.BROWSER_STORAGE_ITEM_NAME = browserStorageItemName;
        this.RESOURCES_URL = resourceUrl;
        this.getTokenFromBrowserStorage();

        //console.log("SessionSbService recovered token: ", this._currentToken")

    }

    signOut() {

    }

    asyncSignIn() {

    }

    saveTokenIntoBrowserStorage() {

    }

    getTokenFromBrowserStorage() {

    }
}