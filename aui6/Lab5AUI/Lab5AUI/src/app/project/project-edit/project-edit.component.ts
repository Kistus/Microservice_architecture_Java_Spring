import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectForm } from '../model/project-form';
import {ProjectService} from "../service/project.service";

@Component({
  selector: 'app-project-edit',
  templateUrl: './project-edit.component.html',
  styleUrls: ['./project-edit.component.css']
})
export class ProjectEditComponent implements OnInit {

  /**
   * project's id.
   */
  uuid: string | undefined;

  /**
   * Single project.
   */
  project: ProjectForm | undefined;

  /**
   * Single project.
   */
  original: ProjectForm | undefined;

  /**
   * @param projectService project service
   * @param professionService profession service
   * @param route activated route
   * @param router router
   */
  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.projectService.getProject(params['projectUuid'])
        .subscribe(project => {
          this.uuid = project.id;
          this.project = {
            name: project.name,
            difficulty: project.difficulty
          };
          this.original = {...this.project};
        });
    });
  }

  /**
   * Updates project.
   */
  onSubmit(): void {
    this.projectService.putProject(this.uuid!, this.project!)
      .subscribe(() => this.router.navigate(['/projects']));
  }

}
