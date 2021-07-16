import { Component, OnInit } from '@angular/core';
import { Product } from '../productservice/product';
import { ProductService } from '../productservice/product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  productname_pattern="[a-z 0-9 A-Z]+";
  productcode_pattern="[a-z0-9A-Z]+";

  product:Product=new Product();
  msg:String;
  errorMsg:String;
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
  }

  addProduct(){
    this.productService.addProduct(this.product)
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
    );
  }
}
