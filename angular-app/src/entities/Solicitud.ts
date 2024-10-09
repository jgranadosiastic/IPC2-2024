import { TipoSolicitudEnum } from "./TipoSolicitudEnum";

export interface Solicitud {
    codigo: string,
    fecha: Date,
    tipo: TipoSolicitudEnum,
    nombrePersona: string,
    salario: number,
    direccion: string,
}