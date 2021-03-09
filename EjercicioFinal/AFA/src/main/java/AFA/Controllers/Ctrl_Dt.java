package AFA.Controllers;

import AFA.DTOs.DTO_Dt;
import AFA.Services.Serv_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/dt")
@RestController
public class Ctrl_Dt {

    @Autowired
    Serv_Dt servDt;

    @GetMapping(value = {"/ver","/ver/{idDt}"})
    public List<DTO_Dt> getDt(@PathVariable(required = false) Integer idDt) {

        List<DTO_Dt> list = new ArrayList<>();

        if(idDt != null){
            list.add(servDt.obtenerDt(idDt));
        }
        else{
            list = servDt.obtenerDts();
        }

        return list;
    }

    @PostMapping("/insertar")
    public void postDt(@RequestBody DTO_Dt dtoDt){
        servDt.insertarDt(dtoDt);
    }

    @DeleteMapping("/borrar/{idDt}")
    public void deleteDt(@PathVariable int idDt) {
        servDt.eliminarDt(idDt);
    }
}
