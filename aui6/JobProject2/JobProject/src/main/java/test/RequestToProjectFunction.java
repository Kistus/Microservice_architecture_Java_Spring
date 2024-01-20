package test;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToProjectFunction implements BiFunction<UUID, PutProjectRequest, Project>
{

    @Override
    public Project apply(UUID id, PutProjectRequest request) {
        return Project.builder()
                .id(id)
                .name(request.getName())
                .difficulty(request.getDifficulty())
                .build();
    }

}
