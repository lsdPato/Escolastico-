package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NrcHorarioDto {
    private Integer nrc;
    private Integer aula;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
