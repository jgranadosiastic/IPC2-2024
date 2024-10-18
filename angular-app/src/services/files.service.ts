import { Injectable } from '@angular/core';
import { RestConstants } from './rest-constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InfoFileResponse } from '../entities/InfoFileResponse';
import { FileData } from '../entities/FileData';

@Injectable({
  providedIn: 'root'
})
export class FilesService {

  restConstants: RestConstants;
  constructor(private httpClient: HttpClient) { 
    this.restConstants = new RestConstants();
  }

  uploadFile(dataToSend: FileData): Observable<InfoFileResponse> {
    let formData: FormData = new FormData();
    formData.append('fileObject', dataToSend.fileObject, dataToSend.fileObject.name);
    formData.append('nombre', dataToSend.nombre);
    return this.httpClient.post<InfoFileResponse>(this.restConstants.API_URL + 'files-example/v1', formData)
  }

  downloadFile(infoFile: InfoFileResponse): string {
    return this.restConstants.API_URL + 'files-example/download?pathFile=' + infoFile.filePath + '&fileName=' + infoFile.fileName;
  }
}
