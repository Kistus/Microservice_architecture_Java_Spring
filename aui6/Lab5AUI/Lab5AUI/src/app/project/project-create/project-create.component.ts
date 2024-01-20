import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectForm } from '../model/project-form';
import {ProjectService} from "../service/project.service";
import * as _uuid from "uuid";
@Component({
  selector: 'app-project-create',
  templateUrl: './project-create.component.html',
  styleUrls: ['./project-create.component.css']
})
export class ProjectCreateComponent implements OnInit {

  /**
   * project's id.
   */
  uuid: string | undefined;

  /**
   * Single project.
   */
  project: ProjectForm | undefined;


  /**
   * @param projectService project service
   * @param professionService profession service
   * @param route activated route
   * @param router router
   */
  constructor(
    private projectService: ProjectService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.uuid = _uuid.v4();
    this.project = {name: '', difficulty: 0}
  }

  /**
   * Updates project.
   */
  onSubmit(): void {
    this.projectService.putProject(this.uuid!, this.project!)
      .subscribe(() => this.router.navigate(['/projects']));
  }

}
