package test;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMemberResponse {

    /**
     * Represents single profession.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Project {

        /**
         * Unique id identifying profession.
         */
        private UUID id;

    }

    /**
     * Unique id identifying character.
     */
    private UUID id;

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
     * Character's strength.
     */
    private Project project;

}
