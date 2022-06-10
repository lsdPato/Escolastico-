package ec.edu.espe.arquitectura.escolastico.educacion.dto;

import lombok.Data;

@Data
public class BusquedaCarrerasDto {

    private final String nombre;

    private final String modalidad;

    private final String nivel;

    private final Integer departamento;

}
