package AFA.Controllers;

import AFA.DTOs.DTO_Dt;
import AFA.Services.Serv_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dt")
public class Ctrl_Dt {

    @Autowired
    Serv_Dt servDt;

    @GetMapping("/ver")//ALL
    public List<DTO_Dt> getDt() {
        return servDt.obtenerDts();
    }

    @GetMapping("/ver/{idDt}")
    public DTO_Dt getDt(@PathVariable int idDt) {
        return servDt.obtenerDt(idDt);
    }

    @PostMapping("/insertar")
    public void postDt(@RequestBody DTO_Dt dtoDt){
        servDt.insertarDt(dtoDt);
    }
}
