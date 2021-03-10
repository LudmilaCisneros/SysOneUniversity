package AFA.ServicesImp;

import AFA.DTOs.DTO_Equipo;
import AFA.Entities.Equipo;
import AFA.Repositories.Repo_Dt;
import AFA.Repositories.Repo_Equipo;
import AFA.Services.IServ_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Equipo implements IServ_Equipo {

    @Autowired
    Repo_Equipo repoEquipo;

    @Autowired
    Repo_Dt repoDt;

    @Override
    public List<DTO_Equipo> obtenerEquipos(){
        return convertirEquiposADTO((List<Equipo>) repoEquipo.findAll());
    }

    @Override
    public DTO_Equipo obtenerEquipo(int cuitEquipo) {
        return convertirEquipoADTO(repoEquipo.findById(cuitEquipo).get());
    }

    @Override
    public void insertarEquipo(DTO_Equipo dtoEquipo) {
        repoEquipo.save(convertirDTOaEquipo(dtoEquipo));
    }

    @Override
    public void eliminarEquipo(int cuitEquipo) {
        repoEquipo.deleteById(cuitEquipo);
    }

    /** Convierte un Equipo a DTO_Equipo
     * @param eq
     * @return eqDTO
     */
    public DTO_Equipo convertirEquipoADTO(Equipo eq) {
        DTO_Equipo dto_equipo = new DTO_Equipo();
        dto_equipo.setIdDt(eq.getDt().getId_dt());
        dto_equipo.setNombre(eq.getNombre());
        dto_equipo.setCUIT(eq.getCUIT());

        return dto_equipo;
    }

    /** Convierte un DTO a Equipo
     * @param eqDto
     * @return eqDTO
     */
    public Equipo convertirDTOaEquipo(DTO_Equipo eqDto) {
        Equipo equipo = new Equipo();

        equipo.setCUIT(eqDto.getCUIT());
        equipo.setNombre(eqDto.getNombre());
        equipo.setDt(repoDt.findById(eqDto.getIdDt()).get());
        //equipo.setDt(servDt.convertirDTOaDt(servDt.obtenerDt(eqDto.getIdDt())));

        return equipo;
    }

    /** Convierte de DTO a Equipos
     * @param list
     * @return
     */
    public List<Equipo> convertirDTOAEquipos(List<DTO_Equipo> list){
        List<Equipo> listEq = new ArrayList<>();

        for (DTO_Equipo dto_equipo : list) {
            listEq.add(convertirDTOaEquipo(dto_equipo));
        }
        return listEq;
    }

    /** Convierte de equipos a DTO
     * @param list
     * @return
     */
    public List<DTO_Equipo> convertirEquiposADTO(List<Equipo> list){
        List<DTO_Equipo> listDTOEq = new ArrayList<>();
        for (Equipo equipo : list) {
            listDTOEq.add(convertirEquipoADTO(equipo));
        }
        return listDTOEq;
    }

}