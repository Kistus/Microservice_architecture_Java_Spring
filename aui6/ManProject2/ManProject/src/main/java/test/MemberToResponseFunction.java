package test;

import org.springframework.stereotype.Component;
import test.GetMemberResponse;
import test.Member;


import java.util.function.Function;

@Component
public class MemberToResponseFunction implements Function<Member, GetMemberResponse> {

    @Override
    public GetMemberResponse apply(Member entity) {
        return GetMemberResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .skill(entity.getHealth())
                .position(entity.getLevel())
                .project(GetMemberResponse.Project.builder()
                        .id(entity.getProfession().getId())
                        .build())
                .build();
    }

}
