package Services;

import DTOs.DTO_Contrato;
import Entities.Contrato;

import java.util.List;

public interface IServ_Contrato {

    public  void printContrato(Contrato c);

    public void printContratos(List<Contrato> contratos);

    public  List<Contrato> convertirContratosDTOAContratos(List<DTO_Contrato> listaDTO);

    public  DTO_Contrato convertirContratoADTO(Contrato contrato);

    public  Contrato convertirDTOAContrato(DTO_Contrato cDTO);

}
