import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public http:HttpClient) { }

  public logIn(user: User): Observable<any> {
     const body = {"mail": user.mail,
                    "mdp":user.password}

    return this.http.post("http://localhost:8080/login",body,{ headers: {'Content-Type': 'application/json'} }) 
   

}

public createUser(user:User){
  const body = {"mail": user.mail,
                "mdp":user.password,
                "nom":user.nom,
                "prenom":user.prenom}
  return this.http.post("http://localhost:8080/register",body);
}
}