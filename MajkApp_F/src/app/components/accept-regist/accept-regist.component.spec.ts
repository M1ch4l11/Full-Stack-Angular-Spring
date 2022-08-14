import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptRegistComponent } from './accept-regist.component';

describe('AcceptRegistComponent', () => {
  let component: AcceptRegistComponent;
  let fixture: ComponentFixture<AcceptRegistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptRegistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
