import { Cidade } from './cidadeEntity';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

private baseurl = "http://localhost:8090/cidades"

constructor(private http:HttpClient) {}


getCidades(id:number):Observable<any>{
  console.log
  return this.http.get(`${this.baseurl}/${id}`)
}

criarCidades(cidade:Object):Observable<Object>{
  return this.http.post(`${this.baseurl}`,cidade)
}

atualizarCidades(id:number,value:any):Observable<Object>{
  return this.http.put(`${this.baseurl}/${id}`,value)
}

removerCidades(id:number):Observable<any>{
  return this.http.delete(`${this.baseurl}/${id}`,{responseType:'text'})
}

getListarCidades(): Observable<any>{
  return this.http.get(`${this.baseurl}`)
}

}
