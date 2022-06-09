package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BusquedaPeriodosDto {

    private final String modalidad;

    private final Date fecha;

}
