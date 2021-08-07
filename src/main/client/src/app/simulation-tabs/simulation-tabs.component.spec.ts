import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimulationTabsComponent } from './simulation-tabs.component';

describe('SimulationTabsComponent', () => {
  let component: SimulationTabsComponent;
  let fixture: ComponentFixture<SimulationTabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SimulationTabsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SimulationTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
