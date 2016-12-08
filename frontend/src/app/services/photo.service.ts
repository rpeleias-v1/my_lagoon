import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Photo } from '../models/photo';
import { User } from '../models/user';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class PhotoService {

    constructor(private http: Http) { }

    getPhotos(): Observable<any> {
        let url = "http://localhost:8080/photo/allPhotos";
        return this.http.get(url);
    }
}