package AFA.Repositories;

import AFA.Entities.Jugador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Jugador extends CrudRepository<Jugador,Integer> {
}
