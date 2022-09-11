import { Router } from '@angular/router';
import { CidadeService } from './../cidade.service';
import { Cidade } from './../cidadeEntity';
import { Component, OnInit } from '@angular/core';

@Component({ 
  selector: 'app-adcionar-cidades',
  templateUrl: './adcionar-cidades.component.html',
  styleUrls: ['./adcionar-cidades.component.css']
})
export class AdcionarCidadesComponent implements OnInit {

  cidade: Cidade = new Cidade();
  submitted = false;


  constructor(private cidadeService:CidadeService, private router:Router) { }

  ngOnInit(): void {
  }

  novaCidade(){
    this.submitted = false;
    this.cidade = new Cidade();
  }

   salvar(){
    this.cidadeService.criarCidades(this.cidade).subscribe(data =>{
      console.log(data)
      this.cidade = new Cidade();
      this.goListaCidade();
    })
  }

  onSubmit(){
    this.submitted = true;
    this.salvar();
  }

  goListaCidade(){
    this.router.navigate(['/cidades'])
  }

}
