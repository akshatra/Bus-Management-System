import { TestBed } from '@angular/core/testing';

import { SrcDestService } from './src-dest.service';

describe('SrcDestService', () => {
  let service: SrcDestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SrcDestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
