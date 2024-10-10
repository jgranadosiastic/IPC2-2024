import { Component, OnInit } from '@angular/core';
import { Solicitud } from '../../entities/Solicitud';
import { TipoSolicitudEnum } from '../../entities/TipoSolicitudEnum';
import { NgFor } from '@angular/common';
import { RequestCardComponent } from '../request-card/request-card.component';
import { SolicitudesRestService } from '../../services/solicitudes/solicitudes-service.service';

@Component({
  selector: 'app-requests-list',
  standalone: true,
  imports: [NgFor, RequestCardComponent],
  templateUrl: './requests-list.component.html',
  styleUrl: './requests-list.component.css'
})
export class RequestsListComponent implements OnInit {
  
  public text = "hola mundo";
  public urlImg = "https://wallpapercave.com/wp/wp7250277.jpg";
  solicitudesList: Solicitud[] = [];

  constructor(private solicitudesRestService: SolicitudesRestService) {}

  ngOnInit(): void {
    // la llamada al servicio
    this.solicitudesRestService
    .obtenerTodasSolicitudes()
    .subscribe({
      next: (listado: Solicitud[]) => {
        console.log("Todo fue bien, procesando response...");
        this.solicitudesList = listado;
      },
      error: (error: any) => {
        console.log(error);
      }
    });
  }

}
