import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from "../user";

@Injectable(
  {providedIn: 'root'}
  )

export class ControlerAPIService {
  usersList?: User[];
  private URL = "http://localhost:8080/user";
  constructor(private httpClient: HttpClient) { 
    
  }

  addUsersToArray(users: User[]| undefined){
    this.usersList = users;
    console.log( "Preslo");
  }

  getUsers(){
    return this.usersList;
  }
  showUsers(){
    this.usersList?.forEach(object => {
      console.log(object.fullName + "..." + object.email);
    })
  }
 
  getUserById(LogName: String): Observable<object>{
    return this.httpClient.get<User>(`${this.URL}/${LogName}`);
  }

  createUser(user: User): Observable<object>{
    return this.httpClient.post(`${this.URL}`,user);
  }

  getAllUserFromDb(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.URL}`);
  }
  
}
