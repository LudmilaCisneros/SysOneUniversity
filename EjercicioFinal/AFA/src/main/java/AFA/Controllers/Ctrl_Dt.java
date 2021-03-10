package AFA.Controllers;

import AFA.DTOs.DTO_Dt;
import AFA.Exceptions.NotFoundException;
import AFA.ServicesImp.Serv_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/dts")
@RestController
public class Ctrl_Dt {

    @Autowired
    Serv_Dt servDt;

    @GetMapping(value = {"/","/{idDt}"})
    public List<DTO_Dt> getDt(@PathVariable(required = false) Integer idDt) {

        List<DTO_Dt> list = new ArrayList<>();

        if(idDt != null){
            try{
                list.add(servDt.obtenerDt(idDt));
            }
            catch (Exception e){
                throw new NotFoundException("Id " + idDt + " No encontrado");
            }
        }
        else{
            list = servDt.obtenerDts();
        }

        return list;
    }

    @PostMapping("/")
    public void postDt(@RequestBody DTO_Dt dtoDt){
        servDt.insertarDt(dtoDt);
    }

    @DeleteMapping("/{idDt}")
    public void deleteDt(@PathVariable int idDt) {
        servDt.eliminarDt(idDt);
    }
}
