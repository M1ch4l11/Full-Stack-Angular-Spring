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

  deleteUserById(id: number){
    const url = `${this.URL}/${id}`;
   return this.httpClient.delete<User>(url).subscribe(obj => console.log(obj));
  }

  getUsers(){
    return this.usersList;
  }
  showUsers(){
    this.usersList?.forEach(object => {
      console.log(object.fullName + "..." + object.email);
    })
  }
 
  getUserById(id: number){
    console.log("Get method " + id);
    return this.httpClient.get<User>(`${this.URL}/${id}`);
  }

  createUser(user: User): Observable<object>{
    return this.httpClient.post(`${this.URL}`,user);
  }

  getAllUserFromDb(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.URL}`);
  }
  
}
