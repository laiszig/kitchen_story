import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  url: string = 'http://localhost:8080';

  //inject the DI
  constructor(private http: HttpClient) {}

  //get all products
  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url + "/products");
  }

  //get product by category
  getProductsByCategory(id: any): Observable<Product[]> {
    return this.http.post<Product[]>(this.url + "/searchproducts", {"categoryId" : id});
}
}
