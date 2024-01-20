package test;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
@AllArgsConstructor
public class ProjectDefaultController
{
    private final ProjectDefaultService projectService;
    private final ProjectToResponseFunction projectToResponse;
    private final ProjectsToResponseFunction projectsToResponse;
    private final RequestToProjectFunction requestToProject;

    /*
    @Autowired
    public ProfessionDefaultController(
            ProfessionService service,
            ProfessionToResponseFunction professionToResponse,
            ProfessionsToResponseFunction professionsToResponse
    ) {
        this.service = service;
        this.professionToResponse = professionToResponse;
        this.professionsToResponse = professionsToResponse;
    }
    */

    @GetMapping("api/projects")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetProjectsResponse getProjects() {
        return projectsToResponse.apply(projectService.findAll());
    }

    @GetMapping("/api/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetProjectResponse getProject(@PathVariable UUID id) {
        return projectService.find(id)
                .map(projectToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/api/projects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable UUID id) {
        projectService.find(id)
                .ifPresentOrElse(
                        profession -> projectService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @PutMapping("/api/projects/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putProject(@PathVariable UUID id, @RequestBody PutProjectRequest request) {
        projectService.create(requestToProject.apply(id, request));
    }

}
