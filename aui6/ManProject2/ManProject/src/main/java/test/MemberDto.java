package test;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Builder
@ToString
public class MemberDto implements Comparable<MemberDto>, Serializable
{
    private String name;
    private int position;
    private int skill;
    private String project;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return position;
    }

    public void setLevel(int position) {
        this.position = position;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getHealth() {
        return skill;
    }

    public void setHealth(int skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto that = (MemberDto) o;
        return position == that.position && Objects.equals(name, that.name) && Objects.equals(project, that.project);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, position, project);
    }


    @Override
    public int compareTo(MemberDto o) {
        return 0;
    }
}