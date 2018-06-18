import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMiningComponent } from './edit-mining.component';

describe('EditMiningComponent', () => {
  let component: EditMiningComponent;
  let fixture: ComponentFixture<EditMiningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditMiningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMiningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
