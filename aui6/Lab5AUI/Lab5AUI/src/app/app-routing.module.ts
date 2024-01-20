import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectListComponent } from "./project/project-list/project-list.component";
import { ProjectEditComponent} from "./project/project-edit/project-edit.component";
import {ProjectCreateComponent} from "./project/project-create/project-create.component";
import {ProjectViewComponent} from "./project/project-view/project-view.component";
import {MemberCreateComponent} from "./member/member-create/member-create.component";
import {MemberEditComponent} from "./member/member-edit/member-edit.component";
import {MemberViewComponent} from "./member/member-view/member-view.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: ProjectListComponent,
    path: "projects"
  },
  {
    component: ProjectEditComponent,
    path: "projects/:projectUuid/edit"
  },
  {
    component: ProjectCreateComponent,
    path: "projects/create"
  },
  {
    component: ProjectViewComponent,
    path: "projects/:projectUuid/details"
  },
  {
    component: MemberCreateComponent,
    path: "projects/:projectUuid/members/create"
  },
  {
    component: MemberEditComponent,
    path: "projects/:projectUuid/members/:memberUuid/edit"
  },
  {
    component: MemberViewComponent,
    path: "projects/:projectUuid/members/:memberUuid/details"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
