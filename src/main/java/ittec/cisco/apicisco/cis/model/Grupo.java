package ittec.cisco.apicisco.cis.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Setter
@Table("grupos")
public class Grupo {
    @Id
    @Column("idGrupo")
    private String idGrupo;
    @Column("idMateria")
    private String idMateria;
    @Column("nombre")
    private String nombre;
    @Column("idSemestre")
    private Integer idSemestre;
    @Column("idProfesor")
    private String idProfesor;


    public String getIdGrupo() {
        return idGrupo;
    }

    public Grupo setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
        return this;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public Grupo setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public Grupo setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public Grupo setIdMateria(String idMateria) {
        this.idMateria = idMateria;
        return this;
    }
}
