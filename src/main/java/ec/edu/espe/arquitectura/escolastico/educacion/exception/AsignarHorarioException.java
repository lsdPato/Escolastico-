package ec.edu.espe.arquitectura.escolastico.educacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AsignarHorarioException extends RuntimeException{
    public AsignarHorarioException(String mensaje){
        super(mensaje);
    }
}
