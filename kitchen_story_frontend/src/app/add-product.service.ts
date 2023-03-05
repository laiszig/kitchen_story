import { Injectable } from '@angular/core';
import { Product } from './product';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddProductService {

  url: string = 'http://localhost:8080/products';

  //inject the DI
  constructor(private httpClient : HttpClient) { }

  addProduct(product: Product) {
    return this.httpClient.post<any>("http://localhost:8080/products", product)
    .pipe(map(result => {
      console.log(result)
        return result;
    }));   
  }
}
