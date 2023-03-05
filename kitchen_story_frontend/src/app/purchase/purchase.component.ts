import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart.service';
import { CartItem } from '../cartItem';
import { CategoryService } from '../category.service';
import { ProductService } from '../product.service';
import { PurchaseService } from '../purchase.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent {
  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private categoryService: CategoryService,
    private cartService: CartService,
    private purchaseService: PurchaseService
  ) {}

  form: any = {
    paymentType: null,
    cardNumber: null,
    cardCvv: null
  };

  items: CartItem[];

  ngOnInit(): void {
    this.items = this.cartService.loadCart();
    console.log(this.items);
  }

  onSubmit(){
    console.log(this.form);
    this.purchaseService.purchase(this.items, this.form)

    .subscribe(
        data => {
            console.log("Processed")
        },
        error => {
          console.log("error")

        });;
  }

  btnClick = () => {
    this.router.navigateByUrl('/cart');
  };

  btnClickPlaceOrder = () => {
    this.router.navigateByUrl('/order-success');
  };
  
}
