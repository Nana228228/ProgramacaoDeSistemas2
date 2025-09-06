import java.math.BigDecimal;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        read();
    }

    // READ
    public static void read() throws SQLException {
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.ohqxmmjnuwgitrckverx&password=HQ9J8#@2025";
                     
        Connection c = DriverManager.getConnection(url);
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet rs = stm. executeQuery();
        while (rs.next()) {
            long nro = rs.getLong("nro_conta");
            BigDecimal saldo = rs. getBigDecimal ("saldo"); 
            System. out. println("Conta número: " + nro + " tem saldo de R$ " + saldo);
        }
        c.close ();
    }
}


