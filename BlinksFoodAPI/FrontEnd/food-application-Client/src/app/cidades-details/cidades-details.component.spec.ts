import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CidadesDetailsComponent } from './cidades-details.component';

describe('CidadesDetailsComponent', () => {
  let component: CidadesDetailsComponent;
  let fixture: ComponentFixture<CidadesDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CidadesDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CidadesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
