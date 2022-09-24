package server;

import client.DaoCurp;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Methods {
    DaoCurp daoCurp = new DaoCurp();

    public String generar(String nombre, String apellido_Paterno, String apellido_Materno, String estado_Nacimiento, String sexo, String fecha_Nacimiento) {
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890";
        int min = 1;
        int max = 10;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;

        Random leRandom = new Random();
        int randomInt = leRandom.nextInt(abc.length());
        String randomChar = String.valueOf(abc.charAt(randomInt));
        String curp = String.valueOf(apellido_Paterno.charAt(0) +
                vocales(apellido_Paterno).charAt(0) +""+ apellido_Materno.charAt(0) +
                "" + nombre.charAt(0) + fecha_Nacimiento.substring(8, 10) +
                fecha_Nacimiento.substring(3, 5) + fecha_Nacimiento.substring(0, 2) + sexo + estado_Nacimiento +
                consonantes(apellido_Paterno).charAt(0)+ consonantes(apellido_Materno).charAt(0)+ consonantes(nombre).charAt(0)+"A" + value+ randomChar);
        System.out.println(curp);
        daoCurp.saveAOperacion(nombre, apellido_Paterno, apellido_Materno, estado_Nacimiento, sexo, curp, fecha_Nacimiento);
        return curp;
    }

    public String consultar(String curp) {
        String buscar = curp;
        String text = "";
        text += daoCurp.listaPersona(buscar);
        return text;
    }

    public static String consonantes(String palabra) {
        char[] palabraChar = palabra.toUpperCase().toCharArray();
        String consonante = "";
        for (int i = 1; i < palabraChar.length; i++) {
            if ((palabraChar[i] != 'A' && palabraChar[i] != 'E' && palabraChar[i] != 'I' && palabraChar[i] != 'O' && palabraChar[i] != 'U')) {
                consonante += palabraChar[i];
            }
        }
        return consonante;
    }


    public static String vocales(String palabra) {
        char[] palabraChar = palabra.toUpperCase().toCharArray();
        String vocal = "";
        for (int i = 1; i < palabraChar.length; i++) {
            if (!(palabraChar[i] == 'A' && palabraChar[i] == 'E' && palabraChar[i] == 'I' && palabraChar[i] == 'O' && palabraChar[i] == 'U')) {
                vocal += palabraChar[i];
            }
        }
        return vocal;
    }

}
