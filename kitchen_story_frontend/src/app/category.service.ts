import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url: string = 'http://localhost:8080/categories';

  //inject the DI
  constructor(private http: HttpClient) {}

  //get all categories
  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url);
  }
}
