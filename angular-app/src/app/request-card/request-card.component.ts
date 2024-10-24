import { Component, Input } from '@angular/core';
import { Solicitud } from '../../entities/Solicitud';
import { TipoSolicitudEnum } from '../../entities/TipoSolicitudEnum';
import { CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-request-card',
  standalone: true,
  imports: [DatePipe, CurrencyPipe],
  templateUrl: './request-card.component.html',
  styleUrl: './request-card.component.css'
})
export class RequestCardComponent {
  @Input({required: true})
  solicitud!: Solicitud;

  @Input()
  soloVer: boolean = false;

  etipoSolicitudEnum = TipoSolicitudEnum;

}
