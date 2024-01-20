import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Members } from "../model/members";
import {Member} from "../model/member";
import {MemberForm} from "../model/member-form";

/**
 * User memberagememberst service. Calls REST endpoints.
 */
@Injectable()
export class MemberService {

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
  getMembers(projectUuid: string): Observable<Members> {
    return this.http.get<Members>('/api/projects/' + projectUuid + '/members');
  }

  getMember(uuid: string): Observable<Member> {
    return this.http.get<Member>('/api/members/' + uuid);
  }

  /**
   * Removes single user.
   *
   * @param uuid user's id
   */
  deleteMember(uuid: string): Observable<any> {
    return this.http.delete('/api/members/' + uuid);
  }

  putMember(uuid: string, request: MemberForm): Observable<any> {
    return this.http.put('/api/members/' + uuid, request);
  }

}
