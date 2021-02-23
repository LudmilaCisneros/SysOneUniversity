package AFA.Repositories;

import AFA.Entities.Contrato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Contrato extends CrudRepository<Contrato,Integer> {
}
