import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accept-regist',
  templateUrl: './accept-regist.component.html',
  styleUrls: ['./accept-regist.component.scss']
})
export class AcceptRegistComponent implements OnInit {

  constructor(private router: Router) { }

  clickSend(){
    this.router.navigate(['']);
  }

  ngOnInit(): void {
  }

}
