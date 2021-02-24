package AFA.Services;

import AFA.DTOs.DTO_Contrato;
import AFA.DTOs.DTO_Equipo;
import AFA.Entities.Equipo;
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

    @Override
    public List<DTO_Contrato> obtenerContratos()
        {
            return convertirContratosADTO((List<Contrato>) repoContrato.findAll());
        }

    //public List<DTO_Equipo> obtenerEquipos(){
        //return convertirEquiposADTO((List<Equipo>) repoEquipo.findAll());
    //}


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


    @Override
    public List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO){
        List<Contrato> contratos = new ArrayList<>();

        for (int i=0;i<listaDTO.size();i++){
            contratos.add(convertirDTOAContrato(listaDTO.get(i)));
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

    @Override
    public DTO_Contrato convertirContratoADTO(Contrato contrato) {
        return new DTO_Contrato(contrato);
    }

    @Override
    public Contrato convertirDTOAContrato(DTO_Contrato cDTO) {
        return new Contrato(cDTO);
    }

}