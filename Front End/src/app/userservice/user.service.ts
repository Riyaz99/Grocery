import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  public addUser(user:User):Observable<any>{
    return this.http.post("http://localhost:7071/user/adduser",user);
  }

  public viewAll():Observable<any>{
    return this.http.get("http://localhost:7071/user/getallusers");
  }

  public viewById(cid:number):Observable<any>{
    return this.http.get("http://localhost:7071/user/getuser/"+cid);
  }

  public updateUser(uid:number, modifyUser:User):Observable<any>{
    return this.http.put("http://localhost:7071/user/updateuser/"+uid,modifyUser,{responseType:'text'});
  }
}
