import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../storage.service';
import { Cart } from './cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  productId:number;

  constructor(private http:HttpClient, public storageservice:StorageService) { }

  public addCart(cart:Cart):Observable<any>{
    return this.http.post("http://localhost:7071/cart/addcart",cart,{responseType:'text'});
  }

  public addToCart(cart:Cart):Observable<any>{
    console.log(JSON.stringify(cart))
    return this.http.put("http://localhost:7071/cart/addtocart",cart,{responseType:'text'});

  }

  public getCart(uid:number):Observable<any>{
    return this.http.get("http://localhost:7071/cart/getcartbyuser/" + uid);
  }
}
