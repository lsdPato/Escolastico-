package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.BusquedaPeriodosDto;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.educacion.service.PeriodoService;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.ModuloService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/periodo")
public class PeriodoResource {

    private final PeriodoService service;

    public PeriodoResource(PeriodoService service) {
        this.service = service;
    }

    @GetMapping(path = "/buscar/modalidad")
    public ResponseEntity<List<Periodo>> getPeriodoModalidad(@RequestBody BusquedaPeriodosDto busqueda){
        return ResponseEntity.ok(this.service.listarPorModalidad(busqueda.getModalidad()));
    }

    @GetMapping(path = "/buscar/modalidadfecha")
    public ResponseEntity<List<Periodo>> listarPorFechaInicialYModalidad(@RequestParam("fecha") String fecha, @RequestParam("modalidad") String modalidad) throws ParseException {
        return ResponseEntity.ok(this.service.listarPorFechaInicialYModalidad(fecha, modalidad));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Periodo periodo){
        try {
            this.service.crear(periodo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}
