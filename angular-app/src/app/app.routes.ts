import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ListarSolicitudesViewComponent } from './listar-solicitudes-view/listar-solicitudes-view.component';
import { MainComponent } from './main/main.component';

export const routes: Routes = [
    {
        path: 'inicio',
        title: 'Inicio',
        component: MainComponent
    },
    {
        path: 'listar-solicitudes',
        title: 'Listado de Solicitudes',
        component: ListarSolicitudesViewComponent
    },
    {
        path: '',
        redirectTo: 'inicio',
        pathMatch: 'full'
        
    },
    { path: '**', redirectTo: 'inicio' }
];
