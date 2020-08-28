import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookedTicketDetailsComponent } from './booked-ticket-details.component';

describe('BookedTicketDetailsComponent', () => {
  let component: BookedTicketDetailsComponent;
  let fixture: ComponentFixture<BookedTicketDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookedTicketDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookedTicketDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
