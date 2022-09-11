import { CidadeService } from './../cidade.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Cidade } from './../cidadeEntity';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cidades-details',
  templateUrl: './cidades-details.component.html',
  styleUrls: ['./cidades-details.component.css']
})
export class CidadesDetailsComponent implements OnInit {

  id: number;
  cidade: Cidade;

  constructor(private route:ActivatedRoute, private router:Router, private cidadeService: CidadeService) {}

  ngOnInit(): void {
    this.cidade = new Cidade();
    this.id = this.route.snapshot.params['id']
    

    this.cidadeService.getCidades(this.id)
    .subscribe(data =>{
      console.log(data)
      this.cidade = data;
    },error => console.log(error))
  }

  listar(){
    this.router.navigate(['cidades'])
  }

}
