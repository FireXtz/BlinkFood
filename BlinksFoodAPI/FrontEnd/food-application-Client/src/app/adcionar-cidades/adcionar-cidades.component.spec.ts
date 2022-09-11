import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdcionarCidadesComponent } from './adcionar-cidades.component';

describe('AdcionarCidadesComponent', () => {
  let component: AdcionarCidadesComponent;
  let fixture: ComponentFixture<AdcionarCidadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdcionarCidadesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdcionarCidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
