import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdcionarCidadesComponent } from './adcionar-cidades/adcionar-cidades.component';
import { CidadesDetailsComponent } from './cidades-details/cidades-details.component';
import { ListarCidadesComponent } from './listar-cidades/listar-cidades.component';
import { AtualizarCidadesComponent } from './atualizar-cidades/atualizar-cidades.component';


@NgModule({
  declarations: [
    AppComponent,
    AdcionarCidadesComponent,
    CidadesDetailsComponent,
    ListarCidadesComponent,
    AtualizarCidadesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
