export class RestConstants {
    public readonly API_URL = 'http://localhost:8080/rest-api-app/api/v1/';

    public getApiURL() : string {
        return this.API_URL;
    }
}