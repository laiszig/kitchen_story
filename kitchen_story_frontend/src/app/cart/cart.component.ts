import {
  Component,
  ElementRef,
  OnInit,
  QueryList,
  ViewChildren,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { CartService } from '../cart.service';
import { CategoryService } from '../category.service';
import { CartItem } from '../cartItem';
import { CurrencyPipe } from '@angular/common';
import { Product } from '../product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  @ViewChildren('subTotalWrap') subTotalItems: QueryList<ElementRef>;
  @ViewChildren('subTotalWrap_existing')
  subTotalItems_existing: QueryList<ElementRef>;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private categoryService: CategoryService,
    private cartService: CartService,
    private currencyPipe: CurrencyPipe
  ) {}

  items: CartItem[];
  item: CartItem;

  ngOnInit(): void {
    this.items = this.cartService.loadCart();
    console.log(this.items);
  }

  //----- remove specific item
  removeFromCart(cartItem: CartItem) {
    console.log('remove item clicked');
    this.cartService.removeItem(cartItem);
    this.items = this.cartService.loadCart();
  }

  //----- clear cart items
  clearCart(items: CartItem[]) {
    this.cartService.clearCart(items);
    this.items = [...this.cartService.loadCart()];
  }

  //----- calculate total
  get total() {
    const calculatePrice = this.items.reduce((prevVal: any, currentVal) => {
      let totalOrderItem = currentVal.quantity * currentVal.price;
      return prevVal + totalOrderItem;
    }, 0);

    const totalPrice = calculatePrice;
    return totalPrice;
  }

  //----- calculate total per item
  changeSubtotal(item:CartItem, index:any) {
    const qty = item.quantity;
    const amt = item.price;
    const subTotal = amt * qty;
    const subTotal_converted = this.currencyPipe.transform(subTotal, "USD");

    this.subTotalItems.toArray()[
      index
    ].nativeElement.innerHTML = subTotal_converted;
    this.cartService.saveCart();
  }

  saveCart() {
    this.cartService.saveCart;
  }



  btnClick() {
    this.router.navigateByUrl('/purchase');
  };
}
