package banco;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public class StartDBDataSource {

    public static String DB_CONN_STRING_CREATE = "jdbc:derby:banco;create=true";
    public static String DB_NAME = "banco";
    public static String USER_NAME = "banco";
    public static String PASSWORD = "123456";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }

    public static void criarBd() throws Exception {
        try (Connection conexao = criarDataSource().getConnection()) {
            //Criando tabela
            String sql
                    = "create table CONTAS("
                    + "NUMERO numeric(3) not null,"
                    + "SALDO decimal(8,2) not null,"
                    + "primary key(NUMERO))";

            try (Statement comando = conexao.createStatement()) {
                comando.executeUpdate(sql);
            }
        }
    }

    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
}
