import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimRequestListComponent } from './claim-request-list.component';

describe('ClaimRequestListComponent', () => {
  let component: ClaimRequestListComponent;
  let fixture: ComponentFixture<ClaimRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClaimRequestListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
