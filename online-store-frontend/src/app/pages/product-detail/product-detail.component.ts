import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  // addToCart(product) {
  //   // this.cartService.addToCart(product); //trebuie implementat un packet service, implicit un fisier cartService 
  //   window.alert('Your product has been added to the cart!');
  // }
  constructor() { }

  ngOnInit(): void {
  }

}
