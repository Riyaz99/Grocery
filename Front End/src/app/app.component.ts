import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './loginService';
import { StorageService } from './storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'OnlineGrocery';
  constructor(private router:Router, public storageservice:StorageService, public loginservice:LoginService){}

  ngOnInit(): void {
    this.router.navigate(['home']);
  }
  logout(){
    this.loginservice.doLogout().subscribe();
    this.storageservice.loginflag=false;
    localStorage.removeItem("userinfo");
    this.router.navigateByUrl("/login");
  }
  editProfile(){

  }
}