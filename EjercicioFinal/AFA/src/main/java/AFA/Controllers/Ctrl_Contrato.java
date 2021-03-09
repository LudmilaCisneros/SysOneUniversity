package AFA.Controllers;

import AFA.DTOs.DTO_Contrato;
import AFA.Services.Serv_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contrato")
public class Ctrl_Contrato {

    @Autowired
    Serv_Contrato servContrato;

    @GetMapping(value = {"/ver","/ver/{idContrato}"})
    public List<DTO_Contrato> getContrato(@PathVariable(required = false) Integer idContrato) {
        List<DTO_Contrato> list = new ArrayList<>();

        if(idContrato != null){
            list.add(servContrato.obtenerContrato(idContrato));
        }
        else{
            list = servContrato.obtenerContratos();
        }

        return list;
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