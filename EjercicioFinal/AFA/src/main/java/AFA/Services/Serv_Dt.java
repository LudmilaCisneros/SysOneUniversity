package AFA.Services;

import AFA.DTOs.DTO_Dt;
import AFA.DTOs.DTO_Equipo;
import AFA.DTOs.DTO_Jugador;
import AFA.Entities.Dt;
import AFA.Entities.Jugador;
import AFA.Repositories.Repo_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Dt implements IServ_Dt {

    @Autowired
    Repo_Dt repoDt;

    @Override
    public List<DTO_Dt> obtenerDts() {
        return convertirDtsADTO((List<Dt>) repoDt.findAll());
    }

    @Override
    public DTO_Dt obtenerDt(int idDt) {
            return convertirDtADTO(repoDt.findById(idDt).get());
    }

    @Override
    public void insertarDt(DTO_Dt dtoDt) {
        repoDt.save(convertirDTOaDt(dtoDt));
    }

    @Override
    public void modificarDt(int idDt, DTO_Dt dtoDt) {

    }

    @Override
    public void eliminarDt(int idDt) {

    }

    public  Dt convertirDTOaDt(DTO_Dt dtoDt){
        return new Dt(dtoDt);
    }

    public DTO_Dt convertirDtADTO(Dt dt) {
        return new DTO_Dt(dt);
    }

    public List<DTO_Dt> convertirDtsADTO(List<Dt> list){
        List<DTO_Dt> listaDTO = new ArrayList<>();

        for (Dt dt : list) {
            listaDTO.add(convertirDtADTO(dt));
        }
        return listaDTO;
    }
}
