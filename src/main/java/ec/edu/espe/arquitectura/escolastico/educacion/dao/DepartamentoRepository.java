
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    List<Departamento> findByNombreLikeOrderByNombre(String nombrePattern);

    List<Departamento> findBySiglas(String siglas);
}