import {Project} from "../../project/model/project";

/**
 * Represents single profession.
 */
export interface Member {

  /**
   * Unique id identifying member.
   */
  id: string;

  /**
   * Name of the member.
   */
  name: string;

  /**
   * Difficulty of the member.
   */
  position: number;

  /**
   * Difficulty of the member.
   */
  skill: number;


  project: Project;
}
