package Services;

import DTOs.DTO_Contrato;
import Entities.Contrato;

import java.util.List;

public interface IServ_Contrato {
    DTO_Contrato obtenerContrato(int idContrato);

    void insertarContrato(DTO_Contrato dtoContrato);

    void modificarContrato(int idContrato, DTO_Contrato dtoContrato);

    void eliminarContrato(int idContrato);

    void printContrato(Contrato c);

    void printContratos(List<Contrato> contratos);

    List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO);

    DTO_Contrato convertirContratoADTO(Contrato contrato);

    Contrato convertirDTOAContrato(DTO_Contrato cDTO);
}
