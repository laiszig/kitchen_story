import { Injectable } from '@angular/core';
import { CartItem } from './cartItem';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  constructor() {}

  localStorageKey : string = "cart";

  public addItem(cartItem: CartItem) {
    let items = this.getData();
    items.push(cartItem);
    localStorage.setItem(this.localStorageKey, JSON.stringify(items));
  }

  public getData(): any[] {
    const items = localStorage.getItem(this.localStorageKey);
    return JSON.parse(items || '[]');
  }

  public removeData() {
    localStorage.removeItem(this.localStorageKey);
  }

  public clearData() {
    localStorage.clear();
  }
}
