package test;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity
@Table(name = "members")
public class Member implements Comparable<Member>, Serializable
{
    @Id
    private UUID id;
    private String name;
    private int position;
    private int skill;
    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

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

    public Project getProfession() {
        return project;
    }

    public void setProfession(Project profession) {
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
        Member character = (Member) o;
        return position == character.position && Objects.equals(name, character.name) && Objects.equals(project, character.project);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, position, project);
    }


    @Override
    public int compareTo(Member o) {
        return 0;
    }
}

