import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { ProjectListComponent } from './project/project-list/project-list.component';
import { HttpClientModule } from "@angular/common/http";
import { ProjectService } from "./project/service/project.service";
import { FormsModule } from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {ProjectEditComponent} from "./project/project-edit/project-edit.component";
import {ProjectCreateComponent} from "./project/project-create/project-create.component";
import {ProjectViewComponent} from "./project/project-view/project-view.component";
import {MemberService} from "./member/service/member.service";
import {MemberCreateComponent} from "./member/member-create/member-create.component";
import {MemberEditComponent} from "./member/member-edit/member-edit.component";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    ProjectListComponent,
    ProjectEditComponent,
    ProjectCreateComponent,
    ProjectViewComponent,
    MemberCreateComponent,
    MemberEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    ProjectService,
    MemberService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
