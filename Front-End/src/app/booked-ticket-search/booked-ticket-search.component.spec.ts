import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookedTicketSearchComponent } from './booked-ticket-search.component';

describe('BookedTicketSearchComponent', () => {
  let component: BookedTicketSearchComponent;
  let fixture: ComponentFixture<BookedTicketSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookedTicketSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookedTicketSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
