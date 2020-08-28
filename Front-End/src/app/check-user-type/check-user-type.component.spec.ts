import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckUserTypeComponent } from './check-user-type.component';

describe('CheckUserTypeComponent', () => {
  let component: CheckUserTypeComponent;
  let fixture: ComponentFixture<CheckUserTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckUserTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckUserTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
