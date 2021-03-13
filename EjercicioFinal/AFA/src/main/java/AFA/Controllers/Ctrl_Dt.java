package AFA.Controllers;

import AFA.DTOs.DTO_Dt;
import AFA.Exceptions.BadRequestException;
import AFA.Exceptions.NotFoundException;
import AFA.ServicesImp.Serv_Dt;
import AFA.Validators.Validator_Dt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/dts")
@RestController
public class Ctrl_Dt {
    @Autowired
    Serv_Dt servDt;

    @GetMapping(value = {"/","/{idDt}"})
    public List<DTO_Dt> getDt(@PathVariable(required = false) Integer idDt) throws NotFoundException {

        List<DTO_Dt> list = new ArrayList<>();

        if(idDt != null){
            try{
                list.add(servDt.obtenerDt(idDt));
            }catch (RuntimeException e){
                throw new NotFoundException("Id " + idDt + " no encontrado");
            }
        }else{
            list = servDt.obtenerDts();
        }
        return list;
    }

    @PostMapping("/")
    public void postDt(@RequestBody @Valid DTO_Dt dtoDt, BindingResult result) throws BadRequestException {

            new Validator_Dt().validate(dtoDt, result);

            if (!result.hasErrors()){
                servDt.insertarDt(dtoDt);
            }else {
                throw new BadRequestException("El dt es incorrecto");
            }
    }

    @DeleteMapping("/{idDt}")
    public void deleteDt(@PathVariable Integer idDt) throws NotFoundException{
        if(idDt != null){
            try{
                servDt.eliminarDt(idDt);
            }catch (RuntimeException e){
                throw new NotFoundException("Id " + idDt + " no encontrado");
            }
        }
    }
}
