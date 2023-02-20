import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {

  constructor(private router:Router, private activatedRoute:ActivatedRoute, private productService:ProductService,
    private categoryService:CategoryService) { }
  products: Product[];
  categories: Category[];

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(result=>this.products=result);
    this.categoryService.getAllCategories().subscribe(result=>this.categories=result);
  }

  btnClick = () => {
    console.log('click');
  };

  categorySelection = (event:any) => {
    const categoryId = event.target.value;
    if(categoryId != 0) {
      this.productService.getProductsByCategory(categoryId).subscribe(result=>this.products=result);
    }    
  };
}
