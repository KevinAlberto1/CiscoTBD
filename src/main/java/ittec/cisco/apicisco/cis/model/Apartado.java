package ittec.cisco.apicisco.cis.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Setter
@Table("apartado")
public class Apartado {
    @Id
    @Column("id")
    private Integer id;
    @Column("aula")
    private String aula;
    @Column("tipoApartado")
    private String tipoApartado;
    @Column("solicitante")
    private short solicitante;
    @Column("fecha")
    private java.time.LocalDate fecha;
    @Column("horaInicio")
    private java.time.LocalTime horaInicio;
    @Column("horaFin")
    private java.time.LocalTime horaFin;

    public Integer getId() {
        return id;
    }

    public Apartado setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public Apartado setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public Apartado setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Apartado setFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public short getSolicitante() {
        return solicitante;
    }

    public Apartado setSolicitante(short solicitante) {
        this.solicitante = solicitante;
        return this;
    }

    public String getTipoApartado() {
        return tipoApartado;
    }

    public Apartado setTipoApartado(String tipoApartado) {
        this.tipoApartado = tipoApartado;
        return this;
    }

    public String getAula() {
        return aula;
    }

    public Apartado setAula(String aula) {
        this.aula = aula;
        return this;
    }
}
