package client;
import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DaoCalculadora {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    private final String SHOW = "SELECT * FROM operations;";

    private final String INSERT_OPERATION = "INSERT INTO operations(`type`,first_number,second_number,result)values (?,?,?,?)";

    public List<BeanCalculadora> showCalculadora (){
        List<BeanCalculadora> calculadoraList = new LinkedList<>();
        BeanCalculadora calculadora = new BeanCalculadora();
        try{
            conn = new MySQLConnection().getConnection();
            String query  = SHOW;
            pstm = conn.prepareStatement(query);
            rs =pstm.executeQuery();
            while (rs.next()){
                calculadora = new BeanCalculadora();
                calculadora.setId(rs.getInt("id"));
                calculadora.setType(rs.getString("type"));
                calculadora.setFirst_number(rs.getDouble("first_number"));
                calculadora.setSecond_number(rs.getDouble("second_number"));
                calculadora.setResult(rs.getDouble("result"));
                calculadora.setCreated_at(rs.getDate("created_at"));


                calculadoraList.add(calculadora);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalculadora.class.getName())
                    .log(Level.SEVERE, "Error en showCalculadora -> " + e);

        }finally {
            closeConnections();

        }
        return calculadoraList;
    }

    @Override
    public String toString() {
        return "DaoCalculadora{" +
                "conn=" + conn +
                ", pstm=" + pstm +
                ", rs=" + rs +
                ", SHOW='" + SHOW + '\'' +
                ", INSERT_OPERATION='" + INSERT_OPERATION + '\'' +
                '}';
    }

    public void closeConnections(){
        try{
            if (conn!=null){
                conn.close();

            }
            if (pstm!=null){
                pstm.close();

            }
            if (rs!=null){
                rs.close();

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public boolean saveAOperacion(BeanCalculadora operation){
        try{
            conn = new MySQLConnection().getConnection();
            pstm = conn.prepareStatement(INSERT_OPERATION);
            pstm.setString(1, operation.getType());
            pstm.setDouble(2, operation.getFirst_number());
            pstm.setDouble(3, operation.getSecond_number());
            pstm.setDouble(4, operation.getResult());
            return pstm.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCalculadora.class.getName()).log(Level.SEVERE, "Error saveOperation", e);
        }finally {
            closeConnections();
        }
        return false;
    }
}
