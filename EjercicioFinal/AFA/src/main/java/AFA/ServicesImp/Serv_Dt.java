package AFA.ServicesImp;

import AFA.DTOs.DTO_Dt;

import AFA.Entities.Dt;
import AFA.Entities.Equipo;
import AFA.Repositories.Repo_Dt;
import AFA.Repositories.Repo_Equipo;
import AFA.Services.IServ_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Dt implements IServ_Dt {

    @Autowired
    Repo_Dt repoDt;

    @Autowired
    Repo_Equipo repoEquipo;

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
    public void eliminarDt(int idDt) { repoDt.deleteById(idDt); }

    public  Dt convertirDTOaDt(DTO_Dt dtoDt){
        Dt dtEntity = new Dt();
        Serv_Equipo servEquipo = new Serv_Equipo();
        Equipo eq;
        dtEntity.setNombre(dtoDt.getNombre());
        dtEntity.setId_dt(dtoDt.getId_dt());
        dtEntity.setEquipo(repoEquipo.findById(dtoDt.getCuitEquipo()).get());

        return dtEntity;
    }

    public DTO_Dt convertirDtADTO(Dt dt) {
        DTO_Dt dtoDt = new DTO_Dt();
        dtoDt.setNombre(dt.getNombre());
        dtoDt.setId_dt(dt.getId_dt());
        dtoDt.setCuitEquipo(dt.getEquipo().getCUIT());

        return dtoDt;
    }

    public List<DTO_Dt> convertirDtsADTO(List<Dt> list){
        List<DTO_Dt> listaDTO = new ArrayList<>();

        for (Dt dt : list) {
            listaDTO.add(convertirDtADTO(dt));
        }
        return listaDTO;
    }
}
