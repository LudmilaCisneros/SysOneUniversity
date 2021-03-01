package AFA.Controllers;

import AFA.DTOs.DTO_Contrato;
import AFA.Services.Serv_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class Ctrl_Contrato {

    @Autowired
    Serv_Contrato servContrato;

    @GetMapping("/ver")//ALL
    public List<DTO_Contrato> getContrato() {
        return servContrato.obtenerContratos();
    }

    @GetMapping("/ver/{idContrato}")
    public DTO_Contrato getContrato(@PathVariable int idContrato) {
        return servContrato.obtenerContrato(idContrato);
    }

    @PostMapping("/insertar")
    public void postContrato(@RequestBody DTO_Contrato dtoContrato) {
        servContrato.insertarContrato(dtoContrato);
    }

    @DeleteMapping("/borrar/{idContrato}")
    public void deleteContrato(@PathVariable int idContrato) {
        servContrato.eliminarContrato(idContrato);
    }
}