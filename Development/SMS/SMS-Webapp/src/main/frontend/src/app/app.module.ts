import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FullLayoutComponent } from './shared/components/full-layout/full-layout.component';
import { SimpleLayoutComponent } from './shared/components/simple-layout/simple-layout.component';
import { SmsHeaderComponent } from './shared/components/full-layout/components/sms-header/sms-header.component';
import { SmsSideBarComponent } from './shared/components/full-layout/components/sms-side-bar/sms-side-bar.component';
import { SmsFooterComponent } from './shared/components/full-layout/components/sms-footer/sms-footer.component';
import { HomeComponent } from './modules/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    FullLayoutComponent,
    SimpleLayoutComponent,
    SmsHeaderComponent,
    SmsSideBarComponent,
    SmsFooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
