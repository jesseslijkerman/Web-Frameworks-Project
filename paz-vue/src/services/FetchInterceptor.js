import * as fetchIntercept from "fetch-intercept";

export class FetchInterceptor{
    static theInstance; // the singleton instance that has been registered
    session;
    router;
    unregister; // callback function to unregister the instance at shutdown

    constructor(session, router) {
        this.session = session;
        this.router = router;
        // fetchIntercept does not register the object closure, only the methods as functions
        // so we need an additional static reference to the singleton's attributes
        FetchInterceptor.theInstance = this;
        this.unregister = fetchIntercept.register(this)

        console.log("FetchInterceptor has been registered; current token = " +
            FetchInterceptor.theInstance.session.getTokenFromBrowserStorage())
    }

    request(url, options) {
        let token = FetchInterceptor.theInstance.session.getTokenFromBrowserStorage()

        if (token == null) {
            // no change
            return [url, options];
        } else if (options == null) {
            // the authorisation header is the only custom option
            return [url, { headers: {Authorization: token}}]
        } else {
            // add authorization header to other options
            let newOptions = {...options};
            newOptions.headers = {
                // TODO combine new Authorization header with existing headers
                Authorization: token
            }
            return  [url, newOptions]
        }
    }
    requestError(error) {}
    response(response) {}
    responseError(error) {}
}