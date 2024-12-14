package ittec.cisco.apicisco.cis.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Setter
@Table("materia")
public class Materia {
    @Id
    @Column("idMateria")
    private String idMateria;
    @Column("nombreMateria")
    private String nombreMateria;

    public String getIdMateria() {
        return idMateria;
    }

    public Materia setId_Materia(String idMateria) {
        this.idMateria = idMateria;
        return this;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public Materia setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        return this;
    }
}
