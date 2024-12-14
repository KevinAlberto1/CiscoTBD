package ittec.cisco.apicisco.cis.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Setter
@Table("solicitante")
public class Solicitante {
    @Id
    @Column("idSolicitante")
    private Short idSolicitante;
    @Column("nombre")
    private String nombre;
    @Column("apellido")
    private String apellido;
    @Column("noControl")
    private String noControl;
    @Column("tipoSolicitante")
    private char tipoSolicitante;
    @Column("idGrupo")
    private String idGrupo;

    public Short getIdSolicitante() {
        return idSolicitante;
    }

    public Solicitante setIdSolicitante(Short idSolicitante) {
        this.idSolicitante = idSolicitante;
        return this;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public Solicitante setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
        return this;
    }

    public char getTipoSolicitante() {
        return tipoSolicitante;
    }

    public Solicitante setTipoSolicitante(char tipoSolicitante) {
        this.tipoSolicitante = tipoSolicitante;
        return this;
    }

    public String getNoControl() {
        return noControl;
    }

    public Solicitante setNoControl(String noControl) {
        this.noControl = noControl;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Solicitante setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Solicitante setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
