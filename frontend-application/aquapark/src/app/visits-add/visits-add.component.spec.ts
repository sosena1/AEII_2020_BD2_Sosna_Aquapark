import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitsAddComponent } from './visits-add.component';

describe('VisitsAddComponent', () => {
  let component: VisitsAddComponent;
  let fixture: ComponentFixture<VisitsAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitsAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
