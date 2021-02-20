package Services;

import DTOs.DTO_Contrato;
import Entities.Contrato;

import java.util.List;

public interface IServ_Contrato {

    public DTO_Contrato obtenerContrato(int idContrato);

    public void insertarContrato(DTO_Contrato dtoContrato);

    public void modificarContrato(int idContrato, DTO_Contrato dtoContrato);

    public void eliminarContrato(int idContrato);

    public  void printContrato(Contrato c);

    public void printContratos(List<Contrato> contratos);

    public  List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO);

    public  DTO_Contrato convertirContratoADTO(Contrato contrato);

    public  Contrato convertirDTOAContrato(DTO_Contrato cDTO);

}
