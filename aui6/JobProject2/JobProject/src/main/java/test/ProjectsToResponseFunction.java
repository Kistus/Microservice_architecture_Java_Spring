package test;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Component
public class ProjectsToResponseFunction implements Function<List<Project>, GetProjectsResponse> {

    @Override
    public GetProjectsResponse apply(List<Project> entities) {
        return GetProjectsResponse.builder()
                .projects(entities.stream()
                        .map(project -> GetProjectsResponse.Project.builder()
                                .id(project.getId())
                                .name(project.getName())
                                .build())
                        .toList())
                .build();
    }
}

