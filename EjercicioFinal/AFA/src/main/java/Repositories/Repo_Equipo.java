package Repositories;

import Entities.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Equipo extends CrudRepository<Equipo,Integer> {

}
