import { TestBed } from '@angular/core/testing';

import { VisitService } from './visit.service';

describe('VisitService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));
  let service: VisitService;  // Może to

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VisitService);
  });

  it('should be created', () => {
    // tslint:disable-next-line:no-shadowed-variable
    const service: VisitService = TestBed.get(VisitService);
    expect(service).toBeTruthy();
  });
});


