import { Component, OnInit } from '@angular/core';
import { iif } from 'rxjs';
import { loginPass } from 'src/app/loginPass';
import { ControlerAPIService } from 'src/app/services/controler-api.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user?: User;
  userList?: User[];
  logUser: loginPass = {logName: ""};
  correctLogin?: boolean;
  correctPassword?: boolean;
  constructor(private service: ControlerAPIService) {
    
   }
  
  clickSend(LogName: String, password: String){
    this.logUser.logName = LogName;
    this.logUser.password = password;
    this.getAllData();
  }

  findUserInArray(){
    this.userList?.forEach(Object => {
      if(Object.logName == this.logUser.logName) {
        this.correctLogin = true;
        console.log("Correct logName");
      };
      if(Object.password == this.logUser.password) {
        this.correctPassword = true; 
        console.log("Correct password ");
      }
    });
  }

  getAllData(){
  this.service.getAllUserFromDb().subscribe(data => {
      this.userList = data;
      if(this.userList != null)console.log("Database is not empty.");
      else console.log("Database is empty.");
      this.findUserInArray();
    });
 
  }


  ngOnInit(): void {
   
  }

}
