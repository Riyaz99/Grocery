import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { UpdateproductsComponent } from './updateproducts/updateproducts.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    AddproductComponent,
    ViewAllComponent,
    UpdateproductsComponent,
    ViewUsersComponent,
    ViewCartComponent,
    EditProfileComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
