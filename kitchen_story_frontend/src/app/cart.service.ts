import { Injectable } from '@angular/core';
import { CartItem } from './cartItem';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  // url: string = 'http://localhost:8080/orderitem';

  constructor() {}

  localStorageKey: string = 'cart';

  public addItem(newCartItem: CartItem) {
    let items = this.getData();
    let found = false;
    for (let index = 0; index < items.length; index++) {
      let cartItem = items[index];
      if (cartItem.id == newCartItem.id) {
        cartItem.quantity++;
        items[index] = cartItem;
        found = true;
      }
    }
    if (found == false) {
      items.push(newCartItem);
    }
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
