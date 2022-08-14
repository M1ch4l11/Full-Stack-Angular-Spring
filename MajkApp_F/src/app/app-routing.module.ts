import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "../app/components/login/login.component";
import { RegisterComponent } from "../app/components/register/register.component";
import { AcceptRegistComponent } from './components/accept-regist/accept-regist.component';
const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'Register', component: RegisterComponent},
  {path: 'Done', component: AcceptRegistComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
