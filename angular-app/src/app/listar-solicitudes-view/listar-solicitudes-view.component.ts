import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { RequestsListComponent } from "../requests-list/requests-list.component";
import { FooterComponent } from "../footer/footer.component";

@Component({
  selector: 'app-listar-solicitudes-view',
  standalone: true,
  imports: [HeaderComponent, RequestsListComponent, FooterComponent],
  templateUrl: './listar-solicitudes-view.component.html',
  styleUrl: './listar-solicitudes-view.component.css'
})
export class ListarSolicitudesViewComponent {

}
