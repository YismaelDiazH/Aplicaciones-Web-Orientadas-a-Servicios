package client;

import client.BeanCurp;
import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DaoCurp {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    private final String INSERT_OPERATION = "INSERT INTO `calculadoracurp`.`datos` (`Nombre`, `Apellido_Paterno`, `Apellido_Materno`, `Estado_Nacimiento`, `Sexo`, `curp`, `Fecha_Nacimiento`) VALUES ( ?, ?, ?, ?, ?,?,?)";


    private final String GET_CURP = "SELECT * FROM datos";
    public List<BeanCurp> showCalculadora (){
        List<BeanCurp> calculadoraList = new LinkedList<>();
        BeanCurp calculadora = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query  = GET_CURP;
            pstm = conn.prepareStatement(query);
            rs =pstm.executeQuery();
            while (rs.next()){
                calculadora = new BeanCurp();

                calculadora.setNombre("Nombre");
                calculadora.setApellido_Paterno("Apellido_Paterno");
                calculadora.setApellido_Materno("Apellido_Materno");
                calculadora.setEstado_Nacimiento("Estado_Nacimiento");
                calculadora.setSexo("Sexo");
                calculadora.setCurp("curp");
                calculadora.setFecha_Nacimiento("Fecha_Nacimiento");


                calculadoraList.add(calculadora);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCurp.class.getName())
                    .log(Level.SEVERE, "Error en showPersons -> " + e);

        }finally {
            closeConnections();

        }
        return calculadoraList;
    }

    @Override
    public String toString() {
        return "DaoCurp{" +
                "conn=" + conn +
                ", pstm=" + pstm +
                ", rs=" + rs +
                ", INSERT_OPERATION='" + INSERT_OPERATION + '\'' +
                ", GET_CURP='" + GET_CURP + '\'' +

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
    public boolean saveAOperacion( String nombre, String apellido_Paterno, String apellido_Materno, String estado_Nacimiento, String sexo,String curp, String fecha_Nacimiento){
        try{
            conn = new MySQLConnection().getConnection();
            pstm = conn.prepareStatement(INSERT_OPERATION);

            pstm.setString(1, nombre);
            pstm.setString(2, apellido_Paterno);
            pstm.setString(3, apellido_Materno);
            pstm.setString(4, estado_Nacimiento);
            pstm.setString(5, sexo);
            pstm.setString(6, curp);
            pstm.setString(7, fecha_Nacimiento);

            return pstm.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCurp.class.getName()).log(Level.SEVERE, "Error saveOperation", e);
        }finally {
            closeConnections();
        }
        return false;
    }
    public String listaPersona(String buscar) {
        String datos = "";
        try {
            conn = new MySQLConnection().getConnection();
            String query = GET_CURP;
            pstm = conn.prepareStatement(query);
            pstm.setString(1,buscar);
            rs = pstm.executeQuery();
            if (rs.next()){
                datos ="Nombre: "+ rs.getString("Nombre");
            }else {
                datos = "no entró";
            }
            datos ="Nombre: "+ rs.getString("Nombre") + "\nApellido paterno: " + rs.getString("Apellido_Paterno")
                    + "\nApellido materno: " + rs.getString("Apellido_Materno") + "\nEstado: " + rs.getString("Estado_Nacimiento")
                    + "\nSexo: " + rs.getString("Sexo")

                    + "\nFecha de nacimiento: " + rs.getString("Fecha_Nacimiento");
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(datos);
        return datos;
    }
}
