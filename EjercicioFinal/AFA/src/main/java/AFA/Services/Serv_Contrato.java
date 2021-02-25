package AFA.Services;

import AFA.DTOs.DTO_Contrato;
import AFA.DTOs.DTO_Jugador;
import AFA.Entities.Jugador;
import AFA.Repositories.Repo_Contrato;
import AFA.Entities.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Contrato implements IServ_Contrato{

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
    public void modificarContrato(int idContrato, DTO_Contrato dtoContrato) {
        Contrato contrato = convertirDTOAContrato(dtoContrato);
        contrato.setIdContrato(idContrato);
        repoContrato.save(contrato);
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
        return new DTO_Contrato(contrato);
    }

    public Contrato convertirDTOAContrato(DTO_Contrato cDTO) {
        Contrato c = new Contrato();
        Jugador jugador = sj.convertirDTOAJugador(sj.obtenerJugador(cDTO.getJugador().getDniJugador()));

        c.setJugador(jugador);

        return c;
    }

}