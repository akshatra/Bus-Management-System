import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterCancelButtonComponent } from './after-cancel-button.component';

describe('AfterCancelButtonComponent', () => {
  let component: AfterCancelButtonComponent;
  let fixture: ComponentFixture<AfterCancelButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterCancelButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterCancelButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
