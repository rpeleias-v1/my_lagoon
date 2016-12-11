import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home.component';
import { RegisterComponent } from './components/register.component';
import { LoginComponent } from './components/login.component';
import { MyAlbumComponent } from './components/my-album.component';
import { AddPhotoComponent } from './components/add-photo.component';

const appRoutes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'my-album',
        component: MyAlbumComponent
    },
    {
        path: 'add-photo',
        component: AddPhotoComponent
    }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);