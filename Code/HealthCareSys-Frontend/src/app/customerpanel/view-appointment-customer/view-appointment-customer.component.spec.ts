import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppointmentCustomerComponent } from './view-appointment-customer.component';

describe('ViewAppointmentCustomerComponent', () => {
  let component: ViewAppointmentCustomerComponent;
  let fixture: ComponentFixture<ViewAppointmentCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAppointmentCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAppointmentCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
