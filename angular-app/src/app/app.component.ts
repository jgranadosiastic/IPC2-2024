import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RequestsListComponent } from './requests-list/requests-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RequestsListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-app';
}
