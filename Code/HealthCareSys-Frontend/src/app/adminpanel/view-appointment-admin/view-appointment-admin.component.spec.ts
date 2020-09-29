import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppointmentAdminComponent } from './view-appointment-admin.component';

describe('ViewAppointmentAdminComponent', () => {
  let component: ViewAppointmentAdminComponent;
  let fixture: ComponentFixture<ViewAppointmentAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAppointmentAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAppointmentAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
