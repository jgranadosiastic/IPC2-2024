import { Component } from '@angular/core';
import { UploadFileFormComponent } from '../upload-file-form/upload-file-form.component';

@Component({
  selector: 'app-files-view',
  standalone: true,
  imports: [UploadFileFormComponent],
  templateUrl: './files-view.component.html',
  styleUrl: './files-view.component.css'
})
export class FilesViewComponent {

}
