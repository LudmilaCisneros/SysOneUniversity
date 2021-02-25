package AFA.Services;

import AFA.DTOs.DTO_Dt;
import AFA.DTOs.DTO_Equipo;
import AFA.Entities.Dt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServ_Dt {
    List<DTO_Dt> obtenerDts();

    DTO_Dt obtenerDt(int idDt);

    void insertarDt(DTO_Dt dtoDt);

    void modificarDt(int idDt, DTO_Dt dtoDt);

    void eliminarDt(int idDt);
}
