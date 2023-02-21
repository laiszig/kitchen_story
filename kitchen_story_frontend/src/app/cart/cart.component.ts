import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { CartService } from '../cart.service';
import { CategoryService } from '../category.service';
import { CartItem } from '../cartItem';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
    private categoryService: CategoryService,
    private cartService: CartService)
     {}

     items: CartItem[];

  ngOnInit(): void {
    this.cartService
    .getData()
  }
}