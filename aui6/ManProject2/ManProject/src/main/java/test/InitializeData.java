package test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InitializeData implements InitializingBean
{
    private final ProjectDefaultService projectService;
    private final MemberDefaultService memberService;

    public void afterPropertiesSet() throws Exception
    {
        Project p1 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76")).members(new ArrayList<>()).build();
        Project p2 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e66")).members(new ArrayList<>()).build();
        Project p3 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e56")).members(new ArrayList<>()).build();
        Project p4 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e46")).members(new ArrayList<>()).build();
        Project p5 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e36")).members(new ArrayList<>()).build();
        Project p6 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e75")).members(new ArrayList<>()).build();
        projectService.create(p1.getId());
        projectService.create(p2.getId());
        projectService.create(p3.getId());
        projectService.create(p4.getId());
        projectService.create(p5.getId());
        projectService.create(p6.getId());

        Member c1 = Member.builder().id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0")).name("Andy").position(8).skill(50).project(p1).build();
        Member c2 = Member.builder().id(UUID.fromString("3c6f1eb1-8069-44ab-988f-d7fed2b65d88")).name("Bill").position(7).skill(100).project(p1).build();
        Member c3 = Member.builder().id(UUID.randomUUID()).name("Carl").position(6).skill(70).project(p1).build();
        Member c4 = Member.builder().id(UUID.randomUUID()).name("Drake").position(5).skill(20).project(p2).build();
        Member c5 = Member.builder().id(UUID.randomUUID()).name("Eric").position(4).skill(30).project(p2).build();
        Member c6 = Member.builder().id(UUID.randomUUID()).name("Felix").position(3).skill(40).project(p3).build();
        Member c7 = Member.builder().id(UUID.randomUUID()).name("Gary").position(2).skill(10).project(p4).build();
        Member c8 = Member.builder().id(UUID.randomUUID()).name("Hugo").position(1).skill(80).project(p5).build();
        memberService.create(c1);
        memberService.create(c2);
        memberService.create(c3);
        memberService.create(c4);
        memberService.create(c5);
        memberService.create(c6);
        memberService.create(c7);
        memberService.create(c8);
    }
}
