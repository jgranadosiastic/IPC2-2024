import { Component } from '@angular/core';
import { RequestFormComponent } from '../request-form/request-form.component';

@Component({
  selector: 'app-request-create-view',
  standalone: true,
  imports: [RequestFormComponent],
  templateUrl: './request-create-view.component.html',
  styleUrl: './request-create-view.component.css'
})
export class RequestCreateViewComponent {

}
