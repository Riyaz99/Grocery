import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public addProduct(product:Product):Observable<any>{
    return this.http.post("http://localhost:7071/product/addproduct",product,{responseType:'text'})
  }

  public viewAll():Observable<any>{
    return this.http.get("http://localhost:7071/product/getallproducts");
  }

  public updateProduct(modifyProduct: Product) {
    return this.http.put("http://localhost:7071/product/updateproduct",modifyProduct,{responseType:'text'});
    
  }

  public getProductById(pid:number):Observable<any>{
    return this.http.get("http://localhost:7071/product/getproduct/"+pid);
  }
}
