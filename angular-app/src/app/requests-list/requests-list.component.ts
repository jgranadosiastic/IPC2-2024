import { Component } from '@angular/core';
import { Solicitud } from '../../entities/Solicitud';
import { TipoSolicitudEnum } from '../../entities/TipoSolicitudEnum';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-requests-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './requests-list.component.html',
  styleUrl: './requests-list.component.css'
})
export class RequestsListComponent {
  public text = "hola mundo";
  public urlImg = "https://wallpapercave.com/wp/wp7250277.jpg";
  solicitudesList: Solicitud[] = [
    {
      'codigo': 'ABC-123',
      'fecha': new Date(2024, 9, 21),
      'tipo': TipoSolicitudEnum.REGIONAL,
      'nombrePersona': 'Nombre 1',
      'salario': 15200.50,
      'direccion': 'direccion 1'
    },
    {
      'codigo': 'ABC-456',
      'fecha': new Date(2024, 8, 21),
      'tipo': TipoSolicitudEnum.NACIONAL,
      'nombrePersona': 'Nombre 2',
      'salario': 25200,
      'direccion': 'direccion 2'
    }
  ];



}
