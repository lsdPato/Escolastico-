package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CarreraService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/carrera")
public class CarreraResource {

    private final CarreraService service;

    public CarreraResource(CarreraService service) {
        this.service = service;
    }

    @GetMapping(path = "/buscar/nombre")
    public ResponseEntity<List<Carrera>> getPorNombre(@RequestParam("nombre") String nombre){
        return ResponseEntity.ok(this.service.obtenerPorNombre(nombre));
    }

    @GetMapping(path = "/buscar/departamento")
    public ResponseEntity<List<Carrera>> listarPorDepartamento(@RequestParam("departamento") Integer departamento){
        return ResponseEntity.ok(this.service.listarPorDepartamento(departamento));
    }

    @GetMapping(path = "/buscar/modalidad")
    public ResponseEntity<List<Carrera>> listarPorModalidad(@RequestParam("modalidad") String modalidad){
        return ResponseEntity.ok(this.service.listarPorModalidad(modalidad));
    }

    @GetMapping(path = "/buscar/nivel")
    public ResponseEntity<List<Carrera>> listarPorNivel(@RequestParam("nivel") String nivel){
        return ResponseEntity.ok(this.service.listarPorNivel(nivel));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Carrera carrera){
        try{
            this.service.crear(carrera);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Carrera> modificar(@RequestBody Carrera carrera){
        try{
            this.service.modificar(carrera);
            carrera = this.service.obtenerPorCodigo(carrera.getCodCarrera());
            return ResponseEntity.ok(carrera);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
