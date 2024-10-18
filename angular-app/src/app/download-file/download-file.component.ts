import { Component, Input, OnInit } from '@angular/core';
import { InfoFileResponse } from '../../entities/InfoFileResponse';
import { FilesService } from '../../services/files.service';

@Component({
  selector: 'app-download-file',
  standalone: true,
  imports: [],
  templateUrl: './download-file.component.html',
  styleUrl: './download-file.component.css'
})
export class DownloadFileComponent implements OnInit {

  @Input()
  infoFile!: InfoFileResponse;

  downloadFileURL: string;

  constructor(private filesService: FilesService) {
    this.downloadFileURL = '';
  }

  ngOnInit(): void {
    this.downloadFileURL = this.filesService.downloadFile(this.infoFile)
  }
  
}
