import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from "../user";

@Injectable(
  {providedIn: 'root'}
  )


export class ControlerAPIService {
  private URL = "http://localhost:8080/user";
  constructor(private httpClient: HttpClient) { 
    
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
