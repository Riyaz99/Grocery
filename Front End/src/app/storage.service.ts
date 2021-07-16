import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Logindto } from './logindto';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  msg:string;
  loginflag:boolean;
  username:string;
  role:string;
  userId:string;
  constructor(public http:HttpClient) {
    if (localStorage.getItem("userinfo")!=null)
    {
      this.loginflag=true;
      this.username=JSON.parse(localStorage.getItem("userinfo")).userName;
      this.role=JSON.parse(localStorage.getItem("userinfo")).role;
      this.userId=JSON.parse(localStorage.getItem("userinfo")).userId;
    }
   }
}

