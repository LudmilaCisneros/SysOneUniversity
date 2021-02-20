package Services;

import DTOs.DTO_Contrato;
import Entities.*;
import Repositories.Repo_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv_Contrato implements IServ_Contrato{

    @Autowired
    Repo_Contrato repoContrato;

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
    public void printContrato(Contrato c) {
        StringBuilder sb = new StringBuilder();

        sb.append("ID CONTRATO: ").append(c.getIdContrato());
        sb.append(" Dni Jugador: ").append(c.getDniJugador());
        sb.append(" cuit Equipo: ").append(c.getCuitEquipo());
        sb.append(" F INICIAL: ").append(c.getFechaIn());
        sb.append(" F FINAL: ").append(c.getFechaFin());
        sb.append(" POSICION: ").append(c.getPosicion()).append("\n");

        System.out.println(sb.toString());
    }

    @Override
    public void printContratos(List<Contrato> contratos) {
        for (Contrato c: contratos) {
            printContrato(c);
        }
    }

    @Override
    public List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO){
        List<Contrato> contratos = new ArrayList<>();

        for (int i=0;i<listaDTO.size();i++){
            contratos.add(convertirDTOAContrato(listaDTO.get(i)));
        }
        return contratos;
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