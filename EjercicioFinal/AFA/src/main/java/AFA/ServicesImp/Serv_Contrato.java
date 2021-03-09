package AFA.ServicesImp;

import AFA.DTOs.DTO_Contrato;
import AFA.Entities.Jugador;
import AFA.Repositories.Repo_Contrato;
import AFA.Entities.Contrato;
import AFA.Services.IServ_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Contrato implements IServ_Contrato {

    @Autowired
    Repo_Contrato repoContrato;

    @Autowired
    Serv_Jugador sj;

    @Override
    public List<DTO_Contrato> obtenerContratos()
    {
        return convertirContratosADTO((List<Contrato>) repoContrato.findAll());
    }

    @Override
    public DTO_Contrato obtenerContrato(int idContrato) {
        return convertirContratoADTO(repoContrato.findById(idContrato).get());
    }

    @Override
    public void insertarContrato(DTO_Contrato dtoContrato) {
        repoContrato.save(convertirDTOAContrato(dtoContrato));
    }

    @Override
    public void eliminarContrato(int idContrato) {
        repoContrato.deleteById(idContrato);
    }

    public List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO){
        List<Contrato> contratos = new ArrayList<>();

        for (DTO_Contrato dto_contrato : listaDTO) {
            contratos.add(convertirDTOAContrato(dto_contrato));
        }
        return contratos;
    }

    public List<DTO_Contrato> convertirContratosADTO(List<Contrato> list){
        List<DTO_Contrato> listDTO = new ArrayList<>();

        for (Contrato contrato : list) {
            listDTO.add(convertirContratoADTO(contrato));
        }
        return listDTO;
    }

    public DTO_Contrato convertirContratoADTO(Contrato contrato) {
        DTO_Contrato dto_contrato = new DTO_Contrato();
        dto_contrato.setDni_jugador(contrato.getJugador().getDniJugador());
        dto_contrato.setIdContrato(contrato.getIdContrato());
        dto_contrato.setFechaIn(contrato.getFechaIn());
        dto_contrato.setFechaFin(contrato.getFechaFin());
        dto_contrato.setPosicion(contrato.getPosicion());
        dto_contrato.setNombreClub(contrato.getNombreClub());

        return dto_contrato;
    }

    public Contrato convertirDTOAContrato(DTO_Contrato cDTO) {
        Contrato cont = new Contrato();
        Jugador jugador;
        cont.setIdContrato(cDTO.getIdContrato());
        cont.setFechaIn(cDTO.getFechaIn());
        cont.setFechaFin(cDTO.getFechaFin());
        cont.setPosicion(cDTO.getPosicion());
        cont.setNombreClub(cDTO.getNombreClub());

        jugador = sj.convertirDTOAJugador(sj.obtenerJugador(cDTO.getDni_jugador()));
        cont.setJugador(jugador);

        return cont;
    }

}