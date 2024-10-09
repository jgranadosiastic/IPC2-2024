import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSolicitudesViewComponent } from './listar-solicitudes-view.component';

describe('ListarSolicitudesViewComponent', () => {
  let component: ListarSolicitudesViewComponent;
  let fixture: ComponentFixture<ListarSolicitudesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarSolicitudesViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarSolicitudesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
