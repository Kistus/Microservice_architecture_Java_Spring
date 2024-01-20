import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Members} from "../model/members";
import {ProjectService} from "../../project/service/project.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MemberService} from "../service/member.service";
import {Member} from "../model/member";


@Component({
  selector: 'app-member-view',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './member-view.component.html',
  styleUrls: ['./member-view.component.css']
})
export class MemberViewComponent implements OnInit{

  member: Member | undefined;
  /**
   *
   * @param service project service
   * @param route activated route
   * @param router router
   */

  constructor(private route: ActivatedRoute, private router: Router, private service: MemberService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMember(params['memberUuid'])
        .subscribe(member => this.member = member)
    });
  }

}
