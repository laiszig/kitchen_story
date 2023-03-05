import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  url: string = 'http://localhost:8080/purchase';

  //inject the DI
  constructor(private http: HttpClient) {}


}
