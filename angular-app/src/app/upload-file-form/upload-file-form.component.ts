import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { FilesService } from '../../services/files.service';
import { FileData } from '../../entities/FileData';
import { InfoFileResponse } from '../../entities/InfoFileResponse';
import { DownloadFileComponent } from '../download-file/download-file.component';

@Component({
  selector: 'app-upload-file-form',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, DownloadFileComponent],
  templateUrl: './upload-file-form.component.html',
  styleUrl: './upload-file-form.component.css'
})
export class UploadFileFormComponent implements OnInit {
  uploadFileForm!: FormGroup;
  creado: boolean = false;
  infoFileResponse!: InfoFileResponse;

  constructor(private formBuilder: FormBuilder, private filesService: FilesService) {

  }
  ngOnInit(): void {
    this.uploadFileForm = this.formBuilder.group(
      {
        fileObject: [null, [Validators.required]],
        nombre: [null, [Validators.required]]
      }
    );
  }

  submit(): void {
    console.log("se hizo submit");
    if (this.uploadFileForm.valid) {
      let fileData = this.uploadFileForm.value as FileData;
      this.filesService.uploadFile(fileData).subscribe({
        next: (infoFileResponse: InfoFileResponse) => {
          this.creado = true;
          this.infoFileResponse = infoFileResponse;
        }
      });
      console.log("subido");
    }
  }

  limpiar(): void {
    this.uploadFileForm.reset({});
  }

  onFileChange(event: Event): void {
    const reader = new FileReader();
    let files = (event.target as HTMLInputElement).files;
    if (files != null) {

      this.uploadFileForm.patchValue({
        fileObject: files[0]
      });
    }
  }

}
