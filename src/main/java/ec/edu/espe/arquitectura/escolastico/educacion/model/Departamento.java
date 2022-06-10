
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_departamento")

public class Departamento implements Serializable {

    private static final long serialVersionUID = 631234456L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Column(name = "siglas", nullable = false, length = 32)
    private String siglas;
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Carrera> carreras;

    public Departamento() {
    }

    public Departamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreraList) {
        this.carreras = carreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartamento != null ? codDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codDepartamento == null && other.codDepartamento != null) || (this.codDepartamento != null && !this.codDepartamento.equals(other.codDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codDepartamento=" + codDepartamento + " ]";
    }

}
