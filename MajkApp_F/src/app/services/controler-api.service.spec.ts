import { TestBed } from '@angular/core/testing';

import { ControlerAPIService } from './controler-api.service';

describe('ControlerAPIService', () => {
  let service: ControlerAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ControlerAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
