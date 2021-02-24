package AFA.Services;

import AFA.DTOs.DTO_Contrato;
import AFA.DTOs.DTO_Equipo;
import AFA.Entities.Contrato;

import java.util.List;

public interface IServ_Contrato {

    List<DTO_Contrato> obtenerContratos();

    DTO_Contrato obtenerContrato(int idContrato);

    void insertarContrato(DTO_Contrato dtoContrato);

    void modificarContrato(int idContrato, DTO_Contrato dtoContrato);

    void eliminarContrato(int idContrato);

    List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO);

    DTO_Contrato convertirContratoADTO(Contrato contrato);

    Contrato convertirDTOAContrato(DTO_Contrato cDTO);
}
