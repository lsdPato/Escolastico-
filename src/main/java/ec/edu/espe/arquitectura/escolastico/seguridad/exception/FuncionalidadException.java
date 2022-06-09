package ec.edu.espe.arquitectura.escolastico.seguridad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)

public class FuncionalidadException extends RuntimeException {
    public FuncionalidadException(String message) {
        super(message);
    }
}
