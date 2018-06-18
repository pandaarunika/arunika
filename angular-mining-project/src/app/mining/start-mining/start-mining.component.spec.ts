import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartMiningComponent } from './start-mining.component';

describe('StartMiningComponent', () => {
  let component: StartMiningComponent;
  let fixture: ComponentFixture<StartMiningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartMiningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartMiningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
