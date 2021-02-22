package Controllers;

import DTOs.DTO_Contrato;
import Services.Serv_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrato")
public class Ctrl_Contrato {
    @Autowired
    Serv_Contrato servContrato;

    @GetMapping("/ver/{idContrato}")
    public DTO_Contrato getContrato(@RequestParam(name = "idContrato") int idContrato) {
        return servContrato.obtenerContrato(idContrato);
    }

    @PostMapping("/insertar")
    public void postContrato(@RequestBody DTO_Contrato dtoContrato) {
        servContrato.insertarContrato(dtoContrato);
    }

    @PutMapping("/modificar/{idContrato}")
    public void putContrato(@PathVariable int idContrato, @RequestBody DTO_Contrato dtoContrato) {
        servContrato.modificarContrato(idContrato, dtoContrato);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteContrato(@PathVariable int idContrato) {
        servContrato.eliminarContrato(idContrato);
    }
}