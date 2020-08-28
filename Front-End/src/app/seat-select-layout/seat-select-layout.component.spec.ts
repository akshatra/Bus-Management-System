import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatSelectLayoutComponent } from './seat-select-layout.component';

describe('SeatSelectLayoutComponent', () => {
  let component: SeatSelectLayoutComponent;
  let fixture: ComponentFixture<SeatSelectLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeatSelectLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatSelectLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
