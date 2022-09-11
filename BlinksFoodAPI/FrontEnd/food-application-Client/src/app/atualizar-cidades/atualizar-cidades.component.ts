import { CidadeService } from './../cidade.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Cidade } from './../cidadeEntity';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-atualizar-cidades',
  templateUrl: './atualizar-cidades.component.html',
  styleUrls: ['./atualizar-cidades.component.css']
})
export class AtualizarCidadesComponent implements OnInit {
  id:number
  cidade:Cidade;

constructor(private route:ActivatedRoute,private router:Router,private cidadeService:CidadeService) { }

  ngOnInit(): void {
    this.cidade = new Cidade();
    this.id = this.route.snapshot.params['id'];

    this.cidadeService.getCidades(this.id)
    .subscribe(data =>{
      console.log(data)
      this.cidade = data;
    }, errror => console.log(errror));

  }
  
  goListaCidade(){
    this.router.navigate(['/cidades'])
  }

onSubmit(){
  this.atualizarCidade();
}
  atualizarCidade(){
    this.cidadeService.atualizarCidades(this.id,this.cidade)
    .subscribe(data => {
      console.log(data);
      this.cidade = new Cidade();
      this.goListaCidade();
    })
  }



}
