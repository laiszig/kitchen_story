import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  products:any = [];

  ngOnInit(): void {
    this.products = [
      {"name" : "carrot", "category" : "vegetable", "price" : "0.99"}
    ]
  }

  btnClick=  () => {
    //this.router.navigate(['payment']);
    console.log("click")
};

}
