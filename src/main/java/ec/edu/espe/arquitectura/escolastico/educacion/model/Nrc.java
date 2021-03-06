/*
 * Copyright 2022 User.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.escolastico.educacion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "edu_nrc")

public class Nrc implements Serializable {

    private static final long serialVersionUID = 62325L;
    @EmbeddedId
    private NrcPK pk;
    @Column(name = "cupo_disponible", nullable = false)
    private Integer cupoDisponible;
    @Column(name = "cupo_registrado", nullable = false)
    private Integer cupoRegistrado;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;
    @JsonBackReference(value = "codMateria")
    @JoinColumns({@JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Materia materia;
    @JsonBackReference(value = "codPeriodo")
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Periodo periodo;
    @JsonBackReference(value = "codPersona")
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona Persona;
    @JsonBackReference(value = "nrcHorario")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<NrcHorario> nrcHorario;
    @JsonBackReference(value = "matriculaNrc")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<MatriculaNrc> matriculaNrc;

    public Nrc() {
    }

    public Nrc(NrcPK nrcPK) {
        this.pk = nrcPK;
    }

    public NrcPK getPk() {
        return pk;
    }

    public void setPk(NrcPK nrcPK) {
        this.pk = nrcPK;
    }

    public Integer getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(Integer cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public Integer getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(Integer cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<NrcHorario> getNrcHorario() {
        return nrcHorario;
    }

    public void setNrcHorario(List<NrcHorario> nrcHorarioList) {
        this.nrcHorario = nrcHorarioList;
    }

    public List<MatriculaNrc> getMatriculaNrc() {
        return matriculaNrc;
    }

    public void setMatriculaNrc(List<MatriculaNrc> matriculaNrcList) {
        this.matriculaNrc = matriculaNrcList;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public ec.edu.espe.arquitectura.escolastico.persona.model.Persona getPersona() {
        return Persona;
    }

    public void setPersona(ec.edu.espe.arquitectura.escolastico.persona.model.Persona persona) {
        Persona = persona;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        return (this.pk != null || other.pk == null) && (this.pk == null || this.pk.equals(other.pk));
    }

    @Override
    public String toString() {
        return "[ nrcPK=" + pk + " ]";
    }

}
