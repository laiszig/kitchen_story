import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ProductListComponent } from './product-list/product-list.component'

const routes: Routes = [
  {"path":"productlist",component:ProductListComponent},
  {"path":"cart",component:CartComponent},
  {"path":"orderdetails",component:OrderDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
