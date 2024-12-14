package ittec.cisco.apicisco.cis.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@Setter
@Table("semestre")
public class Semestre {
    @Id
    @Column("idSemestre")
    private int idSemestre;
    @Column("fechaInicio")
    private LocalDate fechaInicio;
    @Column("fechaFin")
    private LocalDate fechaFin;

    public int getIdSemestre() {
        return idSemestre;
    }

    public Semestre setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
        return this;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Semestre setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Semestre setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }
}
