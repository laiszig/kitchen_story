import { Payment } from "./payment";
import { PurchaseItem } from "./purchaseItem";

export class Purchase{
    items: PurchaseItem[];
    payment: Payment;
}