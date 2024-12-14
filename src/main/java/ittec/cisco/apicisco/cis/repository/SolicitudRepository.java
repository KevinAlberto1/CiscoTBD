package ittec.cisco.apicisco.cis.repository;

import ittec.cisco.apicisco.cis.model.Solicitud;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitudRepository {

    private final JdbcTemplate jdbcTemplate;

    public SolicitudRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Solicitud> findByGrupo(String idGrupo) {
        String query = """
                SELECT 
                    s.idSolicitante,
                    s.nombre AS NombreSolicitante,
                    s.apellido AS ApellidoSolicitante,
                    m.nombreMateria AS Materia,
                    g.nombre AS NombreGrupo,
                    sem.idSemestre AS IdSemestre,
                    p.nombre AS NombreProfesor,
                    p.apellido AS ApellidoProfesor,
                    a.aula AS Aula
                FROM  solicitante s 
                INNER JOIN  grupos g ON s.idGrupo = g.idGrupo
                INNER JOIN  materia m ON g.idMateria = m.idMateria
                INNER JOIN  semestre sem ON g.idSemestre = sem.idSemestre
                INNER JOIN  profesor p ON g.idProfesor = p.idProfesor
                INNER JOIN  apartado a ON s.idSolicitante = a.solicitante
                WHERE  g.idGrupo = ?
                """;

        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Solicitud solicitud = new Solicitud();
            solicitud.setIdSolicitante(rs.getShort("idSolicitante"));
            solicitud.setNombreSolicitante(rs.getString("NombreSolicitante"));
            solicitud.setApellidoSolicitante(rs.getString("ApellidoSolicitante"));
            solicitud.setMateria(rs.getString("Materia"));
            solicitud.setNombreGrupo(rs.getString("NombreGrupo"));
            solicitud.setIdSemestre(rs.getInt("IdSemestre"));
            solicitud.setNombreProfesor(rs.getString("NombreProfesor"));
            solicitud.setApellidoProfesor(rs.getString("ApellidoProfesor"));
            solicitud.setAula(rs.getString("Aula"));
            return solicitud;
        }, idGrupo);
    }
}
