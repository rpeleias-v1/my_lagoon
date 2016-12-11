import { Component } from '@angular/core';
import { PhotoService } from '../services/photo.service';
import { UserService } from '../services/user.service';

import { Photo } from '../models/photo';
import { User } from '../models/user';

import { Router } from '@angular/router';

@Component({
    selector: 'my-album',
    templateUrl: './my-album.component.html'
})
export class MyAlbumComponent {

    private photos: Photo[];
    private user: User;
    private selectedPhoto: Photo;

    constructor(private photoService: PhotoService, private userService: UserService, private router: Router) {
        this.userService.getUserByName(localStorage.getItem("currentUserName")).subscribe(user => {
            this.user = JSON.parse(JSON.parse(JSON.stringify(user))._body);
            console.log(this);
            this.photoService.getPhotosByUser(this.user).subscribe(
                photos => {
                    console.log(console.log(this.photos = JSON.parse(JSON.parse(JSON.stringify(user))._body).photoList));
                },
                error => console.log(error)
            );
        },
            error => console.log(error)
        );
    }

}