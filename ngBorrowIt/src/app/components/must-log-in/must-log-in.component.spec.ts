import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MustLogInComponent } from './must-log-in.component';

describe('MustLogInComponent', () => {
  let component: MustLogInComponent;
  let fixture: ComponentFixture<MustLogInComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MustLogInComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MustLogInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
