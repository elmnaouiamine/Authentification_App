import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  user:User = new User("","","","");

  constructor(private userService:UserService) {}  

  ngOnInit(): void {
  }

  register(){
    this.userService.createUser(this.user).subscribe(data =>{
      console.log(this.user)
      alert("User created successfully")
   },err=>{
     alert("Mail already used")
      });
    }
  }

