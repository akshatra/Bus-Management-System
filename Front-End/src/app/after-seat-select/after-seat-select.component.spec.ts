import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterSeatSelectComponent } from './after-seat-select.component';

describe('AfterSeatSelectComponent', () => {
  let component: AfterSeatSelectComponent;
  let fixture: ComponentFixture<AfterSeatSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfterSeatSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterSeatSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
