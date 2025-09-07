import java.math.BigDecimal;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        //read();
        //create();
        //update();
        delete();
    }

    // READ
    public static void read() throws SQLException {
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.beypcfcejddbytjgauap&password=PrimeiroCRUD";
                     
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
    // CREATE
    public static void create() throws SQLException {

    //RECEBENDO ENTRADAS
    System.out.println("Número para a nova conta: ");
    long nro = Long.parseLong(System.console().readLine());

    System.out.println("Saldo para a nova conta: ");
    BigDecimal saldo = new BigDecimal(System.console().readLine());

    //DADOS PARA A CONEXÃO
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.beypcfcejddbytjgauap&password=PrimeiroCRUD";
    Connection c = DriverManager.getConnection(url);

    //COMANDO SQL 
    String sql = "INSERT INTO contas VALUES (?, ?)";

    //USANDO PreparedStatement PARA REALIZAR A OPERAÇÃO NA DB
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    stm.setBigDecimal(2, saldo);
    int ret = stm.executeUpdate();
    System.out.println("Número de registros inseridos: " + ret);
    c.close();
    }

    //UPDATE
    public static void update() throws SQLException {
        //RECEBENDO ENTRADAS
        System.out.println("Número de conta já existente: ");
        long nro = Long.parseLong(System.console().readLine());

        System.out.println("Novo saldo para essa conta: ");
        BigDecimal saldo = new BigDecimal(System.console().readLine());

        //DADOS PARA A CONEXÃO
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.beypcfcejddbytjgauap&password=PrimeiroCRUD";
        Connection c = DriverManager.getConnection(url);

        //COMANDO SQL 
        String sql = "UPDATE contas SET saldo=? WHERE nro_conta=?";

        //USANDO PreparedStatement PARA REALIZAR A OPERAÇÃO NA DB
        PreparedStatement stm = c.prepareStatement(sql);     
        stm.setBigDecimal(1, saldo);
        stm.setLong(2, nro);
        int ret = stm.executeUpdate();
        System.out.println("Número de registros alterados: " + ret);
        c.close();

    }   
    
    public static void delete() throws SQLException{
        System.out.println("Digite número da conta a ser deletada: ");
        long nro = Long.parseLong(System.console().readLine());

                //DADOS PARA A CONEXÃO
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.beypcfcejddbytjgauap&password=PrimeiroCRUD";
        Connection c = DriverManager.getConnection(url);

        //COMANDO SQL 
        String sql = "DELETE FROM contas WHERE nro_conta=?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setLong(1, nro);

        int ret = stm.executeUpdate();

        System.out.println("Número de registros deletados: " + ret);
    }

}


