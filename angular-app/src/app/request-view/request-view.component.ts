import { Component, OnInit } from '@angular/core';
import { Solicitud } from '../../entities/Solicitud';
import { SolicitudesRestService } from '../../services/solicitudes/solicitudes-service.service';
import { ActivatedRoute } from '@angular/router';
import { RequestCardComponent } from '../request-card/request-card.component';
import { TipoSolicitudEnum } from '../../entities/TipoSolicitudEnum';

@Component({
  selector: 'app-request-view',
  standalone: true,
  imports: [RequestCardComponent],
  templateUrl: './request-view.component.html',
  styleUrl: './request-view.component.css'
})
export class RequestViewComponent implements OnInit {
  
  solicitud!: Solicitud;
  codigo!: string;
  existe: boolean = true;
  etipoSolicitudEnum = TipoSolicitudEnum;

  constructor(private solicitudesService: SolicitudesRestService,
    private route: ActivatedRoute
  ) {

  }

  ngOnInit(): void {
    console.log(this.etipoSolicitudEnum);
    this.codigo = this.route.snapshot.params['codigo'];
    this.solicitudesService.obtenerSolicitud(this.codigo).subscribe({
      next: (solicitud: Solicitud) => {
        this.solicitud = solicitud;
        this.existe = true;
        console.log(this,solicitud);
      },
      error: (error: any) => {
        console.log(error);
        this.existe = false;
      }
    });
  }
}
