import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Projects } from "../model/projects";
import {Project} from "../model/project";
import {ProjectForm} from "../model/project-form";

/**
 * User memberagememberst service. Calls REST endpoints.
 */
@Injectable()
export class ProjectService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all users.
   *
   * @return list of users
   */
  getProjects(): Observable<Projects> {
    return this.http.get<Projects>('/api/projects');
  }

  getProject(uuid: string): Observable<Project> {
    return this.http.get<Project>('/api/projects/' + uuid);
  }

  /**
   * Removes single user.
   *
   * @param uuid user's id
   */
  deleteProject(uuid: string): Observable<any> {
    return this.http.delete('/api/projects/' + uuid);
  }

  putProject(uuid: string, request: ProjectForm): Observable<any> {
    return this.http.put('/api/projects/' + uuid, request);
  }

}
