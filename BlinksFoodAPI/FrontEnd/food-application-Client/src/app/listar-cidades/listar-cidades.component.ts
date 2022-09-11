import { Cidade } from './../cidadeEntity';
import { CidadeService } from './../cidade.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CidadesDetailsComponent } from '../cidades-details/cidades-details.component';

@Component({
  selector: 'app-listar-cidades',
  templateUrl: './listar-cidades.component.html',
  styleUrls: ['./listar-cidades.component.css']
})
export class ListarCidadesComponent implements OnInit {
  cidades: Observable <Cidade[]>

  constructor(private cidadeService:CidadeService, private router:Router) {

  }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.cidades = this.cidadeService.getListarCidades();
  }

  removerCidades(id:number){
   this.cidadeService.removerCidades(id)
   .subscribe(data => {
    console.log(data)
    this.reloadData();
   }, error => console.log(error))
  }

  cidadeDetails(id:number){
   this.router.navigate(['detalhes-cidades',id])
  }

  atualizarCidade(id:number){
    this.router.navigate(['atualizar-cidades',id])
  }


}
