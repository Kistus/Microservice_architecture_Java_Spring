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

    public void afterPropertiesSet() throws Exception
    {
        Project p1 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76")).name("Web").difficulty(5).build();
        Project p2 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e66")).name("C++").difficulty(4).build();
        Project p3 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e56")).name("Back").difficulty(3).build();
        Project p4 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e46")).name("Front").difficulty(2).build();
        Project p5 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e36")).name("Dev").difficulty(2).build();
        Project p6 = Project.builder().id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e75")).name("Platform").difficulty(2).build();
        projectService.create(p1);
        projectService.create(p2);
        projectService.create(p3);
        projectService.create(p4);
        projectService.create(p5);
        projectService.create(p6);
    }
}
