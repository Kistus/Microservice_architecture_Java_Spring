package test;

import org.springframework.stereotype.Component;
import test.GetMembersResponse;
import test.Member;

import java.util.List;
import java.util.function.Function;

/**
 * Coverts {@link List<Character>} to {@link test.GetMembersResponse}.
 */
@Component
public class MembersToResponseFunction implements Function<List<Member>, GetMembersResponse> {

    @Override
    public GetMembersResponse apply(List<Member> entities) {
        return GetMembersResponse.builder()
                .members(entities.stream()
                        .map(character -> GetMembersResponse.Member.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .build())
                        .toList())
                .build();
    }

}

