import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {

  constructor(private router:Router, private activatedRoute:ActivatedRoute, private service:ProductService) { }
  products: Product[];

  ngOnInit(): void {
    this.service.getAllProducts().subscribe(result=>this.products=result);
  }

  btnClick = () => {
    //this.router.navigate(['payment']);
    console.log('click');
  };
}
