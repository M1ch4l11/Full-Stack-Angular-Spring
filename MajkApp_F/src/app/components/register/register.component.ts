import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ControlerAPIService } from 'src/app/services/controler-api.service';
import { User } from 'src/app/user';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  public id?: object;
  public user: User = new User();
  constructor(private service: ControlerAPIService, private router: Router) { }

  clickSend(LogName: String,password: String,FullName: String,email: String){
    this.user.logName= LogName;
    this.user.fullName = FullName;
    this.user.password = password;
    this.user.email = email;
    this.service.createUser(this.user).subscribe(data => {
      this.id = data;
      this.getIdAfterSub();
    });
  }

  getIdAfterSub(){
    if(this.id != null){
      this.router.navigate(['/Done']);
    } else console.log("Create errror return id == null");
  }

  ngOnInit(): void {
  }

}
