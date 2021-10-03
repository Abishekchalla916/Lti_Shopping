import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LtiCartComponent } from './lti-cart/lti-cart.component';
import { LtiOrderComponent } from './lti-order/lti-order.component';
import { LtiProductComponent } from './lti-product/lti-product.component';
import { LtiprodComponent } from './ltiprod/ltiprod.component';

const routes: Routes = [
  {path:'ShowProducts',component:LtiprodComponent},
  { path: 'SingleProduct', component: LtiProductComponent},
  {path:'Cart',component : LtiCartComponent},
  {path : 'Order',component:LtiOrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
