package server;

import client.DaoCurp;
import org.jetbrains.annotations.NotNull;

public class Methods {
    DaoCurp daoCurp = new DaoCurp();
    public String generar( String nombre, String apellido_Paterno, String apellido_Materno, String estado_Nacimiento, String sexo,String fecha_Nacimiento) {
       String curp= String.valueOf(apellido_Paterno.charAt(0) +
                "I"+ apellido_Materno.charAt(0)+
                ""+ nombre.charAt(0) + fecha_Nacimiento.substring(8,10)+
                fecha_Nacimiento.substring(3,5)+ fecha_Nacimiento.substring(0,2)+sexo+estado_Nacimiento+"ZRNA"+(Math.random()*10));
        System.out.println(curp);
        daoCurp.saveAOperacion(nombre,apellido_Paterno,apellido_Materno,estado_Nacimiento,sexo,curp,fecha_Nacimiento);
return curp ;
    }

}
