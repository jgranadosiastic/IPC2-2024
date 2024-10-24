import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestViewComponent } from './request-view.component';

describe('RequestViewComponent', () => {
  let component: RequestViewComponent;
  let fixture: ComponentFixture<RequestViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RequestViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
