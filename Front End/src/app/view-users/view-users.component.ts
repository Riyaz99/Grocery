import { Component, OnInit } from '@angular/core';
import { User } from '../userservice/user';
import { UserService } from '../userservice/user.service';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  users:User[]=[];
  msg:string;
  errorMsg:string;

  constructor(private userService:UserService) { }

  ngOnInit(): void {
    this.userService.viewAll().subscribe(data=>this.users=data);
  }

}
