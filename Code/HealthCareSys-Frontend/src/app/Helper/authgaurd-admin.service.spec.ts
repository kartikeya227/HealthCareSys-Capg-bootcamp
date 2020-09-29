import { TestBed } from '@angular/core/testing';

import { AuthgaurdAdminService } from './authgaurd-admin.service';

describe('AuthgaurdAdminService', () => {
  let service: AuthgaurdAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthgaurdAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
