import { Component, Input, OnInit } from '@angular/core';
import { ControlerAPIService } from 'src/app/services/controler-api.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-show-users',
  templateUrl: './show-users.component.html',
  styleUrls: ['./show-users.component.scss']
})
export class ShowUsersComponent implements OnInit {

  userList: User[] = [];
  userObjects?: User[];
  constructor(private service: ControlerAPIService) { }

  changeObjtoUser(){
    this.userObjects?.forEach(obj => {
      this.userList?.push({
        id: obj.id,
        fullName: obj.fullName,
        email: obj.email,
      });
    });
  }

  deleteuser(id: number){
    const indexOfelement = this.userList.findIndex(obj => {
      return obj.id == id;
    })
    this.userList.splice(indexOfelement,1);
    this.service.deleteUserById(id);
  }

  ngOnInit(): void {
    this.userObjects = this.service.getUsers();
    this.changeObjtoUser();
  }

}
