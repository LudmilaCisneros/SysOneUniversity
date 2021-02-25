package AFA.Repositories;

import AFA.Entities.Dt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Dt extends CrudRepository<Dt,Integer> {
}
