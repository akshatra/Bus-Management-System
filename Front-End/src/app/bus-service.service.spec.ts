import { TestBed } from '@angular/core/testing';

import { BusServiceService } from './bus-service.service';

describe('BusServiceService', () => {
  let service: BusServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BusServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
