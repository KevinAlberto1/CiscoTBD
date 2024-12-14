import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

@Component
public class DatabaseConnectionTester implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            ResultSet rs = connection.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                System.out.println("Tabla encontrada: " + rs.getString("TABLE_NAME"));
            }
        }
    }
}
