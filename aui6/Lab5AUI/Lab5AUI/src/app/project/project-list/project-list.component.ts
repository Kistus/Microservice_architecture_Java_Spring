import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProjectService} from "../service/project.service";
import {Projects} from "../model/projects";
import {Project} from "../model/project";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  /**
   * @param service users service
   */
  constructor(private service: ProjectService) {
  }

  /**
   * Available users.
   */
  projects: Projects | undefined;

  ngOnInit(): void {
    this.service.getProjects()
      .subscribe(projects => this.projects = projects);
  }

  /**
   * Deletes selected user.
   *
   * @param project user to be removed
   */
  onDelete(project: Project): void {
    this.service.deleteProject(project.id)
      .subscribe(() => this.ngOnInit());
  }
}
