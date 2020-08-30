import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl:'./product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  // @Input() product;
  constructor() { }

  ngOnInit(): void {
  }

}
