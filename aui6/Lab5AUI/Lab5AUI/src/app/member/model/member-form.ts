import {Project} from "../../project/model/project";

/**
 * Represents single edition in form.
 */
export interface MemberForm {

  /**
   * Name of the project.
   */
  name: string;

  /**
   * Difficulty of the project.
   */
  position: number;

  skill: number;

  project: string;
}

