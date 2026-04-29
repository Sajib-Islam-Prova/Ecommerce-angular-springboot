import { Routes } from '@angular/router';
import { Admin } from './admin/admin';

export const routes: Routes = [

    {path :"admin", loadChildren:()=>import('./admin/admin').then(m=>m.Admin)},
    {path :"customer", loadChildren: ()=>import('./customer/customer').then(m=>m.Customer)}
];
