package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, MateriaPK> {
    List<Materia> findByNombreLike(String nombrePattern);

}