import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Payment } from './payment';
import { PurchaseItem } from './purchaseItem';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  url: string = 'http://localhost:8080/purchase';

  //inject the DI
  constructor(private httpClient : HttpClient) { }

  purchase(items: PurchaseItem[], payment: Payment) {
    return this.httpClient.post<any>("http://localhost:8080/purchase", { items, payment })
    .pipe(map(result => {
      console.log(result)
        return result;
    }));   
  }
}
