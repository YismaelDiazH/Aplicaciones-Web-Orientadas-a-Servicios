package client;

import com.mysql.cj.util.StringUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner;

public class ClientRPC {
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        DaoCurp dao = new DaoCurp();
        BeanCurp bean = new BeanCurp();
        String  nombre,  apellido_Paterno,  apellido_Materno,  estado_Nacimiento,  sexo,  curp="", fecha_Nacimiento;
        int opc;
        do {
            System.out.println("CALCULO DE CLAVE UNICA DE REGISTRO DE POBLACION --> CURP");
            System.out.println("MENU");
            System.out.println("1.- Calcular CURP");
            System.out.println("2.- Consultar CURP");
            System.out.println("3.-Salir");
            opc = sc.nextInt();

            switch (opc){
                case 1:
        sc.nextLine();
        System.out.println("Ingrese su nombre");
        nombre=sc.nextLine();
        nombre=nombre.toUpperCase();
        System.out.println("Ingrese su apellido Paterno: ");
        apellido_Paterno=sc.nextLine();
        apellido_Paterno=apellido_Paterno.toUpperCase();
        System.out.println("Ingrese su Apellido Materno: ");
         apellido_Materno=sc.nextLine();
        apellido_Materno=apellido_Materno.toUpperCase();
        System.out.println("Ingrese el código de su estado de nacimiento  \n" +
                "AGUASCALIENTES AS \nBAJA CALIFORNIA BC\n" +
                "BAJA CALIFORNIA SUR BS \nCAMPECHE CC\n" +
                "COAHUILA CL \nCOLIMA CM\n" +
                "CHIAPAS CS \nCHIHUAHUA CH\n" +
                "DISTRITO FEDERAL DF \nDURANGO DG\n" +
                "GUANAJUATO GT \nGUERRERO GR\n" +
                "HIDALGO HG \nJALISCO JC\n" +
                "MÉXICO MC \nMICHOACÁN MN\n" +
                "MORELOS MS \nNAYARIT NT\n" +
                "NUEVO LEÓN NL \nOAXACA OC\n" +
                "PUEBLA PL \nQUERÉTARO QT\n" +
                "QUINTANA ROO QR \nSAN LUIS POTOSÍ SP\n" +
                "SINALOA SL \nSONORA SR\n" +
                "TABASCO TC \nTAMAULIPAS TS\n" +
                "TLAXCALA TL \nVERACRUZ VZ\n" +
                "YUCATÁN YN \nZACATECAS ZS\n" +
                "NACIDO EN EL EXTRANJERO NE");
        estado_Nacimiento=sc.nextLine();
        estado_Nacimiento=estado_Nacimiento.toUpperCase();
        System.out.println("Ingrese una fecha de nacimiento en formato(DD/MM/AAAA): ");
        fecha_Nacimiento=sc.nextLine();
        fecha_Nacimiento=fecha_Nacimiento.toUpperCase();
        System.out.println("Ingrese su sexo (H/M):");
        sexo=sc.nextLine();
        sexo=sexo.toUpperCase();
        System.out.println(nombre+  apellido_Paterno  +apellido_Materno +estado_Nacimiento+  sexo+ fecha_Nacimiento);

        Object[] data = { nombre,  apellido_Paterno,  apellido_Materno,  estado_Nacimiento,  sexo, fecha_Nacimiento};
        String response = (String) client.execute("Methods.generar", data);
        System.out.println("Result -> " + response);
        bean.setCurp(response);
                    break;
                case 2:
                    System.out.println("Ingresa curp para buscar");
                    curp = sc.next().toUpperCase();
                    Object[] data2 = new Object[]{curp};
                    String datos = (String) client.execute("Methods.consultar",data2);
                    System.out.println(datos);

                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;

            }
        }while (opc<3);
}


}
