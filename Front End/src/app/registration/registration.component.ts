import { Component, OnInit } from '@angular/core';
import { Cart } from '../cartservice/cart';
import { CartService } from '../cartservice/cart.service';
import { User } from '../userservice/user';
import { UserService } from '../userservice/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  firstname_pattern="[a-z A-Z]+";
  lastname_pattern="[a-z A-Z]+";
  phone_pattern="[6-9]{1}[0-9]{9}";
  country_pattern="[a-z A-Z]+";
  state_pattern="[a-z A-Z]+";
  pincode_pattern="[1-9][0-9]{5}";
  district_pattern="[a-z A-Z]+";
  email_pattern="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";
  password_pattern="[a-zA-Z0-9]+[@#$%]+[a-zA-Z0-9]*|[@#$%]+[a-zA-Z0-9]+";

  cart:Cart=new Cart();
  user:User=new User();
  ref:User=new User();

  msg:String;
  errorMsg:String;
  constructor(private userService:UserService,private cartService:CartService) { }

  ngOnInit(): void {
  }

  addUser(){
    this.ref=JSON.parse(JSON.stringify(this.user));
    this.user.role="user";
    this.userService.addUser(this.user)
    .subscribe
    (
      (data)=>
      {
        console.log("data",data);
        this.msg=data.message;
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
  /*addCart(){
    console.log(this.ref);
    this.cart.userEntityId=this.ref.userId;
    this.cartService.addCart(this.cart)
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
  }*/

}
