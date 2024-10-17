import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Solicitud } from '../../entities/Solicitud';
import { RestConstants } from '../rest-constants';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SolicitudesRestService {
  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  public obtenerTodasSolicitudes(): Observable<Solicitud[]> {
    return this.httpClient.get<Solicitud[]>(this.restConstants.getApiURL() + 'solicitudes' );
  }

  public crearSolicitud(solicitud: Solicitud): Observable<void> {
    return this.httpClient.post<void>(this.restConstants.API_URL + 'solicitudes', solicitud);
  }
}
