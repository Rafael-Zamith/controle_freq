package br.mack.ps2;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "xd";
            String url = "jdbc:mysql://localhost:32775/" + db;
            String user = "root";
            String psw = "root";

            conn = DriverManager.getConnection(url, user, psw);
            Statement statement = conn.createStatement();

            statement.executeUpdate("INSERT INTO presenca " + "VALUES (3, 31914454, 1434, 1534)");

            String sql = "SELECT * FROM presenca";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();



            while (rs.next()) {

                int tia = rs.getInt("tia");
                Time hr_entrada = rs.getTime("hr_entrada");
                Time hr_saida = rs.getTime("hr_saida");
                System.out.println("Tia: " + tia);
            }
            rs.close();
            conn.close();
        } 
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch(InstantiationException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
