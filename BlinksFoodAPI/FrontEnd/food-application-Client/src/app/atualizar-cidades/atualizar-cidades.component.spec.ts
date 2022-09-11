import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualizarCidadesComponent } from './atualizar-cidades.component';

describe('AtualizarCidadesComponent', () => {
  let component: AtualizarCidadesComponent;
  let fixture: ComponentFixture<AtualizarCidadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtualizarCidadesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtualizarCidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
