package test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MembersRepository extends JpaRepository<Member, UUID>
{
    List<Member> findAllByProject(Project project);
}
