import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {

  url: string = 'http://localhost:8080/orders';


  constructor() { }
}
