import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MemberForm } from '../model/member-form';
import {MemberService} from "../service/member.service";

@Component({
  selector: 'app-member-edit',
  templateUrl: './member-edit.component.html',
  styleUrls: ['./member-edit.component.css']
})
export class MemberEditComponent implements OnInit {

  /**
   * job's id.
   */
  uuid: string | undefined;

  /**
   * Single job.
   */
  member: MemberForm | undefined;

  /**
   * Single job.
   */
  original: MemberForm | undefined;

  /**
   * @param memberService job service
   * @param professionService profession service
   * @param route activated route
   * @param router router
   */
  constructor(
    private memberService: MemberService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.memberService.getMember(params['memberUuid'])
        .subscribe(member => {
          this.uuid = member.id;
          this.member = {
            name: member.name,
            position: member.position,
            skill: member.skill,
            project: member.project.id
          };
          this.original = {...this.member};
        });
    });
  }

  /**
   * Updates job.
   */
  onSubmit(): void {
    this.memberService.putMember(this.uuid!, this.member!)
      .subscribe(() => this.router.navigate(['jobs/' + this.member?.project + '/details']));
  }

}
