package test;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMemberFunction implements BiFunction<UUID, PutMemberRequest, Member> {

    @Override
    public Member apply(UUID id, PutMemberRequest request) {

        return Member.builder()
                .id(id)
                .name(request.getName())
                .position(request.getPosition())
                .skill(request.getSkill())
                .project(Project.builder()
                        .id(request.getProject())
                        .build())
                .build();
    }

}
