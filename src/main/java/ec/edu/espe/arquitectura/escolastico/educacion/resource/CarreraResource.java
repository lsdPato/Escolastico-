package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.BusquedaCarrerasDto;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CarreraService;
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
    public ResponseEntity<List<Carrera>> getPorNombre(@RequestBody BusquedaCarrerasDto busqueda){
        return ResponseEntity.ok(this.service.obtenerPorNombre(busqueda.getNombre()));
    }

    @GetMapping(path = "/buscar/departamento")
    public ResponseEntity<List<Carrera>> listarPorDepartamento(@RequestBody BusquedaCarrerasDto busqueda){
        return ResponseEntity.ok(this.service.listarPorDepartamento(busqueda.getDepartamento()));
    }

    @GetMapping(path = "/buscar/modalidad")
    public ResponseEntity<List<Carrera>> listarPorModalidad(@RequestBody BusquedaCarrerasDto busqueda){
        return ResponseEntity.ok(this.service.listarPorModalidad(busqueda.getModalidad()));
    }

    @GetMapping(path = "/buscar/nivel")
    public ResponseEntity<List<Carrera>> listarPorNivel(@RequestBody BusquedaCarrerasDto busqueda){
        return ResponseEntity.ok(this.service.listarPorNivel(busqueda.getNivel()));
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
