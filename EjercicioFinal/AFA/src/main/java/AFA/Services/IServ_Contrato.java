package AFA.Services;

import AFA.DTOs.DTO_Contrato;

import java.util.List;

public interface IServ_Contrato {

    List<DTO_Contrato> obtenerContratos();

    DTO_Contrato obtenerContrato(int idContrato);

    void insertarContrato(DTO_Contrato dtoContrato);

    void modificarContrato(int idContrato, DTO_Contrato dtoContrato);

    void eliminarContrato(int idContrato);

}
