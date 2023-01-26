import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { DemoNgZorroAntdModule } from './ng-zorro-antd.module';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { AllCentersComponent } from './components/all-centers/all-centers.component';
import { AuthInterceptor } from './interceptor/auth-interceptor';
import { OneCenterComponent } from './components/one-center/one-center.component';
import { SheduledAppointmentsComponent } from './components/sheduled-appointments/sheduled-appointments.component';
import { FinishedAppointmentsComponent } from './components/finished-appointments/finished-appointments.component';
import { AllComplaintsCenterComponent } from './components/all-complaints/all-complaints.component';
import { AllComplaintsEmployeeComponent } from './components/all-complaints-employee/all-complaints-employee.component';
import { AnswersComponent } from './components/answers/answers.component';
import { SurveyComponent } from './components/survey/survey.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomepageComponent,
    AllCentersComponent,
    OneCenterComponent,
    SheduledAppointmentsComponent,
    FinishedAppointmentsComponent,
    AllComplaintsCenterComponent,
    AllComplaintsEmployeeComponent,
    AnswersComponent,
    SurveyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DemoNgZorroAntdModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
