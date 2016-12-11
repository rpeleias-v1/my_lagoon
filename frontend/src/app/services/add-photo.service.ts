import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Photo} from '../models/photo'
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AddPhotoService {

    constructor(private http:Http) {}

    sendPhoto(photo:Photo): Observable<any> {
        let url = "http://localhost:8080/rest/photo/add";
        let header = new Headers({'Content-type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token")})
        return this.http.post(url, JSON.stringify(photo), {headers: header});
    }
}