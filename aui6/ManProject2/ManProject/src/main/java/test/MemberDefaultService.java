package test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberDefaultService
{
    private final MembersRepository repository;
    
    private final ProjectsRepository projectsRepository;
    

    public List<Member> findAll() {
        return repository.findAll();
    }
    
    public List<Member> findAll(Project project) {
        return repository.findAllByProject(project);
    }
    
    public Optional<List<Member>> findAllByProject(UUID projectId) {
        Optional<Project> opt = projectsRepository.findById(projectId);
        if (opt.isEmpty())
        {
            return Optional.empty();
        }
        else
        {
            return Optional.ofNullable(repository.findAllByProject(opt.get()));
        }

        //return projectsRepository.findById(projectId)
               //.map(repository::findAllByProject);
    }
    
    public void create(Member Member) {
        if (projectsRepository.findById(Member.getProject().getId()).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else
        {
            repository.save(Member);
        }
    }
    
    public void update(Member Member) {
        repository.save(Member);
    }

    public Optional<Member> find(UUID id)
    {
        return repository.findById(id);
    }
    
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
    

}
