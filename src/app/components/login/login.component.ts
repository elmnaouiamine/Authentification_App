import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  user:User = new User("","","","");

  constructor(private userService:UserService,private router:Router){}
  ngOnInit(): void {
     
  }

  login(){
    this.userService.logIn(this.user).subscribe(data=>{
       console.log(this.user)
       alert("Login successful")
    },err=>{
      alert("Mail or password incorrect")
       }
    )
    }
  }


