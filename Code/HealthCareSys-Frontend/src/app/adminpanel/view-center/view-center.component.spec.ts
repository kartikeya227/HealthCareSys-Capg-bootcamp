import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCenterComponent } from './view-center.component';

describe('ViewCenterComponent', () => {
  let component: ViewCenterComponent;
  let fixture: ComponentFixture<ViewCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
