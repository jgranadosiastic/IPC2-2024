import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestCreateViewComponent } from './request-create-view.component';

describe('RequestCreateViewComponent', () => {
  let component: RequestCreateViewComponent;
  let fixture: ComponentFixture<RequestCreateViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RequestCreateViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestCreateViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
