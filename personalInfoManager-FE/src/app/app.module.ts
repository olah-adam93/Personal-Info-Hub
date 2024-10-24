import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { PersonFormComponent } from './components/person-form/person-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PersonListComponent } from './components/person-list/person-list.component';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    PersonFormComponent,
    PersonListComponent,
  ],
  imports: [BrowserModule, ReactiveFormsModule, CommonModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
