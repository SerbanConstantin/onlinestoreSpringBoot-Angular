import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  model: RegisterModel = {
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
export interface RegisterModel {
  username: string;
  email: string;
  password: string;
}