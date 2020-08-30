import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './pages/cart/cart.component';
import { RegisterComponent } from './pages/register/register.component';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { ProductEditComponent } from './pages/product-edit/product-edit.component';
import { OrderComponent } from './pages/order/order.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { LoginComponent } from './pages/login/login.component';
import { FooterComponent} from './navigation/footer/footer.component';
import { MenuBarComponent} from './navigation/menu-bar/menu-bar.component';
import { PaginationComponent} from './navigation/pagination/pagination.component';
import { CardsComponent } from './pages/cards/cards.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    RegisterComponent,
    ProductListComponent,
    ProductDetailComponent,
    ProductEditComponent,
    OrderComponent,
    PaymentComponent,
    LoginComponent,
    FooterComponent,
    MenuBarComponent,
    PaginationComponent,
    CardsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
