import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UpdateproductsComponent } from './updateproducts/updateproducts.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { ViewUsersComponent } from './view-users/view-users.component';

const routes: Routes = [
  {'path':'home',component:HomeComponent},
  {'path':'addproduct',component:AddproductComponent},
  {'path':'updateproducts',component:UpdateproductsComponent},
  {'path':'viewusers',component:ViewUsersComponent},
  {'path':'login',component:LoginComponent},
  {'path':'login/register',component:RegistrationComponent},
  {'path':'viewproducts',component:ViewAllComponent},
  {'path':'viewcart',component:ViewCartComponent},
  {'path':'editprofile',component:EditProfileComponent},
  {'path':'about',component:AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
