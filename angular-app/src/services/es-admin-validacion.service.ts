import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";

@Injectable({
    providedIn: 'root'
  })
export class EsAdminValidacion implements CanActivate {
    
    constructor(private router: Router) {

    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
        console.log(localStorage);
        console.log(localStorage.getItem('rol'));

        if (localStorage.getItem('rol') != 'Admin') {
            this.router.navigate(['/archivos']);
            return false;
        }

        return true;
    }



}