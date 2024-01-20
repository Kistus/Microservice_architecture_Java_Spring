package test;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProjectToResponseFunction implements Function<Project, GetProjectResponse>
{
    @Override
    public GetProjectResponse apply(Project entity) {
        return GetProjectResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .difficulty(entity.getDifficulty())
                .build();
    }

}

