package ittec.cisco.apicisco.cis.model;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Setter
@Table("profesor")
public class Profesor {
   @Id
   @Column("idProfesor")
   private String idProfesor;
   @Column("nombre")
   private String nombre;
   @Column("apellido")
   private String apellido;

   public String getNombre() {
      return nombre;
   }

   public Profesor setNombre(String nombre) {
      this.nombre = nombre;
      return this;
   }

   public String getIdProfesor() {
      return idProfesor;
   }

   public Profesor setIdProfesor(String idProfesor) {
      this.idProfesor = idProfesor;
      return this;
   }

   public String getApellido() {
      return apellido;
   }

   public Profesor setApellido(String apellido) {
      this.apellido = apellido;
      return this;
   }
}
