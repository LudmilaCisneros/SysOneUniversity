package AFA.Services;

import AFA.DTOs.DTO_Dt;
import AFA.DTOs.DTO_Equipo;
import AFA.Entities.Dt;
import AFA.Entities.Equipo;
import AFA.Repositories.Repo_Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Equipo implements IServ_Equipo{

    @Autowired
    Repo_Equipo repoEquipo;

    @Autowired//
    Serv_Dt servDt;

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
    public void modificarEquipo(int cuitEquipo, DTO_Equipo dtoEquipo) {
        Equipo equipo = convertirDTOaEquipo(dtoEquipo);
        equipo.setCUIT(cuitEquipo);
        repoEquipo.save(equipo);
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

        DTO_Equipo eqDTO = new DTO_Equipo();//debo hacer un obtener Dt y setearle al dt de dto
        //Serv_Dt sd = new Serv_Dt();
        //DTO_Dt dtDTO = sd.obtenerDt(eq.getDt().getIdDt());

        eqDTO.setDt(servDt.convertirDTOaDt(servDt.obtenerDt(eq.getDt().getId_dt())));
        eqDTO.setCUIT(eq.getCUIT());
        eqDTO.setNombre(eq.getNombre());


        return eqDTO;
    }

    /** Convierte un DTO a Equipo
     * @param eqDto
     * @return eqDTO
     */
    public Equipo convertirDTOaEquipo(DTO_Equipo eqDto) {
        return new Equipo(eqDto);
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