package AFA.Controllers;

import AFA.DTOs.DTO_Contrato;
import AFA.ServicesImp.Serv_Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/contratos")
@RestController
public class Ctrl_Contrato {

    @Autowired
    Serv_Contrato servContrato;

    @GetMapping(value = {"/","/{idContrato}"})
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

    @PostMapping("/")
    public void postContrato(@RequestBody DTO_Contrato dtoContrato) {
        servContrato.insertarContrato(dtoContrato);
    }

    @DeleteMapping("/{idContrato}")
    public void deleteContrato(@PathVariable int idContrato) {
        servContrato.eliminarContrato(idContrato);
    }
}