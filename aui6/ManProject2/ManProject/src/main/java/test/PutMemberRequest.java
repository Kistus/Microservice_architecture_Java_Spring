package test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutMemberRequest
{

    /**
     * Name of the character.
     */
    private String name;

    /**
     * Character's background story.
     */
    private int position;

    /**
     * Character's age.
     */
    private int skill;

    /**
     * Identifier of the character's profession.
     */
    private UUID project;

}
