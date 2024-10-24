import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ListarSolicitudesViewComponent } from './listar-solicitudes-view/listar-solicitudes-view.component';
import { MainComponent } from './main/main.component';
import { RequestCreateViewComponent } from './request-create-view/request-create-view.component';
import { FilesViewComponent } from './files-view/files-view.component';
import { RequestViewComponent } from './request-view/request-view.component';
import { EsAdminValidacion } from '../services/es-admin-validacion.service';

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
        path: 'crear-solicitud',
        title: 'Crear Solicitud',
        component: RequestCreateViewComponent,
        canActivate: [EsAdminValidacion]
    },
    {
        path: 'ver-solicitud/:codigo',
        title: 'Ver Solicitud',
        component: RequestViewComponent
    },
    {
        path: 'archivos',
        title: 'Archivos',
        component: FilesViewComponent
    },
    {
        path: '',
        redirectTo: 'inicio',
        pathMatch: 'full'
        
    },
    { path: '**', redirectTo: 'inicio' }
];
