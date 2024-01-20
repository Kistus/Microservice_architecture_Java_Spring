package test;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "projects")
public class Project implements Comparable<Project>, Serializable
{
    @Id
    private UUID id;
    private String name;
    private int difficulty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project that = (Project) o;
        return difficulty == that.difficulty && Objects.equals(name, that.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, difficulty);
    }



    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
