import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./shared/components/full-layout/full-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {SimpleLayoutComponent} from "./shared/components/simple-layout/simple-layout.component";

const routes: Routes = [
  {path: '', component: FullLayoutComponent, children:[
      {path: 'home', component: HomeComponent}
    ]},
  {path: '', component: SimpleLayoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
