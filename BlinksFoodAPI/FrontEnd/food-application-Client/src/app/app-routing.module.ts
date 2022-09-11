import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdcionarCidadesComponent } from './adcionar-cidades/adcionar-cidades.component';
import { AtualizarCidadesComponent } from './atualizar-cidades/atualizar-cidades.component';
import { ListarCidadesComponent } from './listar-cidades/listar-cidades.component';
import { CidadesDetailsComponent } from './cidades-details/cidades-details.component';

const routes: Routes = [

  { path: '', redirectTo: 'cidades', pathMatch: 'full' },
  { path: 'cidades', component: ListarCidadesComponent },
  { path: 'adcionar-cidades', component: AdcionarCidadesComponent },
  { path: 'atualizar-cidades/:id', component: AtualizarCidadesComponent },
  { path: 'detalhes-cidades/:id', component: CidadesDetailsComponent },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})




export class AppRoutingModule { }
