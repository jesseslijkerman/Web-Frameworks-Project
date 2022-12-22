export class SessionSbService {
    BROWSER_STORAGE_ITEM_NAME;
    RESOURCES_URL;
    currentToken;
    currentAccount;

    constructor(resourceUrl, browserStorageItemName) {
        this.BROWSER_STORAGE_ITEM_NAME = browserStorageItemName;
        this.RESOURCES_URL = resourceUrl;
        this.getTokenFromBrowserStorage();

        //console.log("SessionSbService recovered token: ", this._currentToken")

    }

    signOut() {
        this.saveTokenIntoBrowserStorage(null, null)
    }

    async asyncSignIn(email, password) /* :Promise<User> */ {
        const body = JSON.stringify({email: email, password: password});
        let response = await fetch(this.RESOURCES_URL + "/login", {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: body,
            credentials: 'include',
            })

            if (response.ok) {
                let user = await response.json();
                this.saveTokenIntoBrowserStorage(
                    response.headers.get('Authorization'),
                    user
                );
                return user;
            } else {
                console.log(response)
                return null;
            }




    }

    saveTokenIntoBrowserStorage(token, account) {
        this.currentToken = token;
        this.currentAccount = account;

        if (token == null) {
            this.currentAccount == null;
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME);
            window.sessionStorage.removeItem(this.BROWSER_STORAGE_ITEM_NAME+"ACC");
        } else {
            window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME, token);
            window.sessionStorage.setItem(this.BROWSER_STORAGE_ITEM_NAME+"ACC", JSON.stringify(account));
        }
    }

    getTokenFromBrowserStorage() {

    }
}