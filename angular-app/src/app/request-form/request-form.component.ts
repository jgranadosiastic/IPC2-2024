import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Solicitud } from '../../entities/Solicitud';
import { SolicitudesRestService } from '../../services/solicitudes/solicitudes-service.service';

@Component({
  selector: 'app-request-form',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './request-form.component.html',
  styleUrl: './request-form.component.css'
})
export class RequestFormComponent implements OnInit {
  solicitudForm!: FormGroup;
  solicitud!: Solicitud;
  creado: boolean = false;

  constructor (private formBuilder: FormBuilder, private solicitudService: SolicitudesRestService) {

  }
  ngOnInit(): void {
    this.solicitudForm = this.formBuilder.group(
      {
        codigo: [null, [Validators.required, Validators.minLength(6)]],
        fecha: [null, [Validators.required]],
        tipo: [null, [Validators.required]],
        nombrePersona: [null, [Validators.required, Validators.maxLength(100)]],
        salario: [1, [Validators.required, Validators.min(1)]],
        direccion: [null, [Validators.maxLength(150)]]
      }
    );
  }

  submit(): void {
    console.log("se hizo submit");
    if (this.solicitudForm.valid) {
      // hacer algo
      this.solicitud = this.solicitudForm.value as Solicitud;
      this.solicitudService.crearSolicitud(this.solicitud).subscribe({
        next: () => {
          this.creado = true;
          this.limpiar();
        },
        error: (error: any) => {
          console.log(error);
          this.creado = false;
        }
      });
      console.log(this.solicitud);
    }
  }

  limpiar() : void {
    this.solicitudForm.reset({salario: 1});
  }
}
