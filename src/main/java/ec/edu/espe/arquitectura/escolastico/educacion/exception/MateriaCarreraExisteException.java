package ec.edu.espe.arquitectura.escolastico.educacion.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MateriaCarreraExisteException extends RuntimeException{
    public MateriaCarreraExisteException(String message){
        super(message);
    }
}
