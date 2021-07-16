import { Component, OnInit } from '@angular/core';
import { Cart } from '../cartservice/cart';
import { CartService } from '../cartservice/cart.service';
import { Product } from '../productservice/product';
import { ProductService } from '../productservice/product.service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  cart:Cart=new Cart();
  products:Product[]=[];
  addedToCart:boolean=false;
  msg:string;
  errorMsg:string;
  amount:number;

  constructor(private productService:ProductService,private cartService:CartService, public storageservice:StorageService) { }

  ngOnInit(): void {
    this.productService.viewAll().subscribe(data=>this.products=data);
  }
 /* calculate(){
    this.amount =this.products.price * this.cart.quantity;
  }*/

  addToCart(productId,quantity){
    //this.cart.cartId=3;
    console.log(this.storageservice.userId)
    this.cart.userEntityId=parseInt(this.storageservice.userId);
    this.cart.productId=productId;
    this.cart.quantity=quantity;
    console.log(this.cart)
    this.cartService.addToCart(this.cart)
    .subscribe
    (
      (data)=>
      {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      },      
      (error)=>
      {
        this.errorMsg=error.error;
        console.log(error.error);
        this.msg=undefined
      }
    )

  }
}
