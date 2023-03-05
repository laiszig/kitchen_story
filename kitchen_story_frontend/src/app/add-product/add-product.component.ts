import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AddProductService } from '../add-product.service';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
  constructor(
    private router: Router,
    private productService: ProductService,
    private categoryService: CategoryService,
    private addProductService: AddProductService
  ) {}

  products: Product[];
  categories: Category[];

  form: any = {
    name: null,
    category: null,
    price: null
  };

  ngOnInit(): void {
    this.categoryService
      .getAllCategories()
      .subscribe((result) => (this.categories = result));
  }

  onSubmit(){
    console.log(this.form);
    this.addProductService.addProduct(this.form)

    .subscribe(
        data => {
            console.log("Processed")
        },
        error => {
          console.log("error")

        });
  }

  btnClick = () => {
    console.log("Item added!");
  };

  categorySelection = (event: any) => {
    const categoryId = event.target.value;
    this.form.category = categoryId
  };
}
