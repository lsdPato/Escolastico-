package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.MallaCarreraDto;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MallaCarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mallaCarrera")
public class MallaCarreraResource {

    private final MallaCarreraService service;

    public MallaCarreraResource(MallaCarreraService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> asignarMateriaCarrera(@RequestBody MallaCarreraDto mallaCarreraDto){
        try{
            this.service.asignarMateriaCarrera(mallaCarreraDto.getMateria(), mallaCarreraDto.getCarrera(), mallaCarreraDto.getNivel());
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/buscar/carrera")
    public ResponseEntity<List<MallaCarrera>> listarPorCarrera(@RequestParam("carrera") Integer carrera){
        return ResponseEntity.ok(this.service.listarMallaPorCarrera(carrera));
    }

    @GetMapping(path = "/buscar/carreraynivel")
    public ResponseEntity<List<MallaCarrera>> listarPorCarreraYNivel(@RequestParam("carrera") Integer carrera, @RequestParam("nivel") Integer nivel){
        return ResponseEntity.ok(this.service.listarMallaPorCarreraYNivel(carrera, nivel));
    }

}
