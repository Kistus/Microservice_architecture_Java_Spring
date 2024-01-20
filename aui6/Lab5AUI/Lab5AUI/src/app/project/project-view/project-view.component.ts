import { Component, OnInit } from '@angular/core';
import {ProjectService} from "../service/project.service";
import { ActivatedRoute, Router } from "@angular/router";
import { ProjectDetails } from "../model/project-details";
import {Projects} from "../model/projects";
import {Project} from "../model/project";
import {MemberService} from "../../member/service/member.service";
import {Members} from "../../member/model/members";
import {Member} from "../../member/model/member";

/**
 * Preview of single project.
 */
@Component({
  selector: 'app-project-view',
  templateUrl: './project-view.component.html',
  styleUrls: ['./project-view.component.css']
})
export class ProjectViewComponent implements OnInit {

  /**
   * Single project.
   */
  project: ProjectDetails | undefined;
  members: Members | undefined;

  /**
   *
   * @param service project service
   * @param route activated route
   * @param router router
   * @param memberService
   */
  constructor(private service: ProjectService, private route: ActivatedRoute, private router: Router, private memberService: MemberService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getProject(params['projectUuid'])
        .subscribe(project => this.project = project)
    });

    this.route.params.subscribe(params => {
      this.memberService.getMembers(params['projectUuid'])
        .subscribe(members => this.members = members);
    });
  }

  onDelete(member: Member): void {
    this.memberService.deleteMember(member.id)
      .subscribe(() => this.ngOnInit());
  }

}

