import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCidadesComponent } from './listar-cidades.component';

describe('ListarCidadesComponent', () => {
  let component: ListarCidadesComponent;
  let fixture: ComponentFixture<ListarCidadesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarCidadesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
