import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmComponent } from './admin/adm/adm.component';
import { LoginComponent } from './admin/login/login.component';
import { ProductsComponent } from './admin/products/products.component';
import { BuyComponent } from './buy/buy.component';
import { AuthGuard } from './shared/auth.guard';
import { WebsiteComponent } from './website/website.component';

const routes: Routes = [
  {
    path: 'admin', component: AdmComponent,
    children: [
      {path: 'login', component: LoginComponent},
      {path: 'products', component: ProductsComponent,  canActivate: [AuthGuard]}
    ]
  },
  {
    path: '', component: WebsiteComponent,
    children: [
      {path: 'buy', component: BuyComponent}     
    ]    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
