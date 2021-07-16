import { Component, OnInit } from '@angular/core';
import { StorageService } from '../storage.service';
import { User } from '../userservice/user';
import { UserService } from '../userservice/user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  firstname_pattern="[a-z A-Z]+";
  lastname_pattern="[a-z A-Z]+";
  phone_pattern="[6-9]{1}[0-9]{9}";
  country_pattern="[a-z A-Z]+";
  state_pattern="[a-z A-Z]+";
  pincode_pattern="[1-9][0-9]{5}";
  district_pattern="[a-z A-Z]+";
  email_pattern="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+";
  password_pattern="[a-zA-Z0-9]+[@#$%]+[a-zA-Z0-9]*|[@#$%]+[a-zA-Z0-9]+";

  
  user:User;
  modifyUser = new User();
  updateDiv:boolean=false;
  msg:string;
  errorMsg:string;

  constructor(private userService:UserService, public storageservice:StorageService) { }

  ngOnInit(): void {
    this.userService.viewById(parseInt(this.storageservice.userId)).subscribe(
      data=>{
        console.log(data);
        this.user=data;
  }
  );
}
update(user:User)
  {
    console.log(JSON.stringify(user));
    this.modifyUser=user;
    this.updateDiv=true;//make update division visible
  }
  cancel()
  {
    this.updateDiv=false;//make update division invisible
  }
  updateUser(){
    this.updateDiv=false;//make update division invisible
    this.userService.updateUser(parseInt(this.storageservice.userId),this.modifyUser)
    .subscribe(data=>{
    this.msg=data;
    this.errorMsg=undefined;
    //Reload account
    this.userService.viewAll().subscribe(data=>this.user=data);
    console.log(this.user);
    },
    error=>{
      this.errorMsg=error.error;
      this.msg=undefined;
    });
  }
}
