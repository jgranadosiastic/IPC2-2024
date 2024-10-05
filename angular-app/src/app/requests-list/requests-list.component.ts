import { Component } from '@angular/core';

@Component({
  selector: 'app-requests-list',
  standalone: true,
  imports: [],
  templateUrl: './requests-list.component.html',
  styleUrl: './requests-list.component.css'
})
export class RequestsListComponent {
  public text = "hola mundo";
  public urlImg = "https://wallpapercave.com/wp/wp7250277.jpg";

}
