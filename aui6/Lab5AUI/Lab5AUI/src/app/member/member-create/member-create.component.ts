import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MemberForm } from '../model/member-form';
import {MemberService} from "../service/member.service";
import * as _uuid from "uuid";
@Component({
  selector: 'app-member-create',
  templateUrl: './member-create.component.html',
  styleUrls: ['./member-create.component.css']
})
export class MemberCreateComponent implements OnInit {

  /**
   * project's id.
   */
  uuid: string | undefined;

  /**
   * Single project.
   */
  member: MemberForm | undefined;


  /**
   * @param MemberService project service
   * @param professionService profession service
   * @param route activated route
   * @param router router
   */
  constructor(
    private memberService: MemberService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.uuid = _uuid.v4();
      this.member = {name: '', position: 0, skill: 0, project: params['projectUuid']}
    });
  }

  /**
   * Updates project.
   */
  onSubmit(): void {
      this.memberService.putMember(this.uuid!, this.member!)
        .subscribe(() => this.router.navigate(['/projects/' + this.member?.project + '/details']));
    }

}
