package model.calculadora;
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

    private final String GET_PERSONS = "SELECT * FROM operations";
    public List<BeanCalculadora> showCalculadora (){
        List<BeanCalculadora> calculadoraList = new LinkedList<>();
        BeanCalculadora calculadora = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query  = GET_PERSONS;
            pstm = conn.prepareStatement(query);
            rs =pstm.executeQuery();
            while (rs.next()){
                calculadora = new BeanCalculadora();
                calculadora.setId(rs.getInt("id"));
                calculadora.setType(rs.getString("type"));
                calculadora.setFirst_number(rs.getDouble("first_number"));
                calculadora.setSecond_number(rs.getDouble("second_number"));
                calculadora.setResult(rs.getDouble("result"));
                calculadora.setCreated_at(rs.getDate(""));


                calculadoraList.add(calculadora);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalculadora.class.getName())
                    .log(Level.SEVERE, "Error en showPersons -> " + e);

        }finally {
            closeConnections();

        }
        return calculadoraList;
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
}
