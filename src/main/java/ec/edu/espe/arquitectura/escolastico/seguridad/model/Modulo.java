
package ec.edu.espe.arquitectura.escolastico.seguridad.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "seg_modulo")

public class Modulo implements Serializable {

    private static final long serialVersionUID = 1324321L;
    @Id
    @Column(name = "cod_modulo", nullable = false, length = 16)
    private String codModulo;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "version", nullable = false)
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codModulo")
    private List<Funcionalidad> funcionalidades;

    public Modulo() {
    }

    public Modulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Funcionalidad> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidad> funcionalidadList) {
        this.funcionalidades = funcionalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codModulo=" + codModulo + " ]";
    }

}
