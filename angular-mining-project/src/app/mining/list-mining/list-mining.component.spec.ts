import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMiningComponent } from './list-mining.component';

describe('ListMiningComponent', () => {
  let component: ListMiningComponent;
  let fixture: ComponentFixture<ListMiningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMiningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMiningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
