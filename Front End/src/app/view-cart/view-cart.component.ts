import { Component, OnInit } from '@angular/core';
import { Cart } from '../cartservice/cart';
import { CartService } from '../cartservice/cart.service';
import { Product } from '../productservice/product';
import { ProductService } from '../productservice/product.service';

import { StorageService } from '../storage.service';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css']
})
export class ViewCartComponent implements OnInit {
  product:Product;
  carts:any= [];

  constructor(private productService:ProductService, public storageservice:StorageService, public cartService:CartService) { }

  ngOnInit(): void {
    this.cartService.getCart(parseInt(this.storageservice.userId)).subscribe(data=>{console.log(data); this.carts=data});
    //this.productService.getProductById(this.cart.productId).subscribe(data=>this.product=data);
  }
}
