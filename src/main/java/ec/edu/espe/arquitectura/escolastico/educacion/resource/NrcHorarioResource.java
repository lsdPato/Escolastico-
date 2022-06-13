package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.NrcHorarioDto;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.escolastico.educacion.service.NrcHorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/horario")
public class NrcHorarioResource {

    private final NrcHorarioService service;

    public NrcHorarioResource(NrcHorarioService service) {
        this.service = service;
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<List<NrcHorario>> listarPorMateriaYPeriodo(@RequestParam("materia") Integer materia,
                                                                     @RequestParam("periodo") Integer periodo){
        return ResponseEntity.ok(this.service.listarPorMateriaYPeriodo(materia, periodo));
    }

    @PostMapping
    public ResponseEntity<String> asignarHorario(@RequestBody NrcHorarioDto nrcHorarioDto){
        try{
            this.service.asignarHorario(nrcHorarioDto.getNrc(), nrcHorarioDto.getAula(), nrcHorarioDto.getDia(),
                    nrcHorarioDto.getHoraInicio(), nrcHorarioDto.getHoraFin());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
