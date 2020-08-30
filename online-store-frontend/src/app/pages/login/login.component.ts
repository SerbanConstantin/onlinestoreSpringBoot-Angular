import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: LoginModel = {
    username: '',
    email: '',
    password: ''
  };
  constructor() { }

  ngOnInit(): void {
  }

  sendFeedback(): void {
    {
        alert("Testul functioneaza, te rugam sa faci si implentarea cu baza de date!");
      }
  }

}
export interface LoginModel {
  username: string;
  email: string;
  password: string;
}