import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../productservice/product';
import { ProductService } from '../productservice/product.service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-updateproducts',
  templateUrl: './updateproducts.component.html',
  styleUrls: ['./updateproducts.component.css']
})
export class UpdateproductsComponent implements OnInit {

  productname_pattern="[a-z 0-9 A-Z]+";
  productcode_pattern="[a-z0-9A-Z]+";
  
  products:Product[]=[];
  modifyProduct=new Product();
  updateDiv:boolean=false;
  msg:string;
  errorMsg:string;

  constructor(private productService:ProductService, public storageservice:StorageService, public router:Router) { }

  ngOnInit(): void {
    if(this.storageservice.loginflag == false || this.storageservice.role != 'admin')
    this.router.navigateByUrl("/login");
    else{
    this.productService.viewAll().subscribe(data=>this.products=data);
  }
}

  update(product:Product)
  {
    console.log(JSON.stringify(product));
    this.modifyProduct=product;
    this.updateDiv=true;//make update division visible
  }
  cancel()
  {
    this.updateDiv=false;//make update division invisible
  }
  updateProduct(){
    this.updateDiv=false;//make update division invisible
    this.productService.updateProduct(this.modifyProduct)
    .subscribe(data=>{
    this.msg=data;
    this.errorMsg=undefined;
    //Reload account
    this.productService.viewAll().subscribe(data=>this.products=data);
    console.log(this.products);
    },
    error=>{
      this.errorMsg=error.error;
      this.msg=undefined;
    });
  }
}
