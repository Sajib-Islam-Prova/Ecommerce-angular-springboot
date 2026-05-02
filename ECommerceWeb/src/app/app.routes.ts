import { Routes } from '@angular/router';
import { Admin } from './admin/admin';
import { Login } from './login/login';
import { Signup } from './signup/signup';

export const routes: Routes = [
    {path :"login" , component:Login},
    {path:"signup",component:Signup},
    {path :"admin", loadChildren:()=>import('./admin/admin').then(m=>m.Admin)},
    {path :"customer", loadChildren: ()=>import('./customer/customer').then(m=>m.Customer)}
];
