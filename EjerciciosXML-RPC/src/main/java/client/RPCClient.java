package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner read = new Scanner(System.in);
        read.useDelimiter("\n");
        int practica = 0;
        Object[] data = {};
        String response;
        System.err.println("Díaz Hernández Andrés Yismael");
                System.out.println("¿Qué Ejercicio deseas mostrar?" +
                "\n1. " +
                "Practica 1" +
                "\n2. Practica 2" +
                "\n3. Practica 3" +
                "\n4. Practica 4");
        practica = read.nextInt();
        switch (practica){
            case 1://Díaz Hernández Andrés Yismael
                String nombre = null;
                Double peso = 0.0;
                Double altura = 0.0;
                System.out.println("Cual es tu nombre");read.nextLine();
                nombre = read.nextLine();

                System.out.println("Cual es tu peso");
                peso = read.nextDouble();
                System.out.println("Cual es tu Altura");
                altura = read.nextDouble();

                 data = new Object[]{nombre, peso, altura};
                response = (String) client.execute("Methods.person", data);
                System.out.println("Result -> " + response);
                break;
            case 2:
                //Díaz Hernández Andrés Yismael
                Double num1, num2, num3, num4, suma, promedio, producto = 0.0;
                System.out.println("Hola, ¿Cuál es el valor 1?");
                num4 = read.nextDouble();
                System.out.println("¿Cuál es el valor 2?");
                num1 = read.nextDouble();
                System.out.println("¿Cuál es el valor 3?");
                num2 = read.nextDouble();
                System.out.println("¿Cuál es el valor 4?");
                num3 = read.nextDouble();
                suma = (num1 + num2 + num3 + num4);
                promedio = (suma/4);
                producto = (num1*num2*num3*num4);

                data = new Object[] {producto, suma, promedio};
                response = (String) client.execute("Methods.producto", data);
                System.out.println("Result -> " + response);
                break;
            case 3:
                //Díaz Hernández Andrés Yismael
                Double  minimo, maximo, suma1 = 0.0;
                System.out.println("Hola, Ingresa un número");
                num1 = read.nextDouble();
                System.out.println("Ingresa otro número");
                num2 = read.nextDouble();
                minimo = Math.min(num1, num2);
                maximo = Math.max(num1, num2);
                System.out.print("Se sumaron: ");
                for (double i = minimo+1; i <maximo; i++) {

                    System.out.print( i + " |");
                }
                for (double i = minimo+1; i < maximo; i++) {
                    suma1+=i;
                }
                System.out.println();

                 data = new Object[]{suma1};
                 response = (String) client.execute("Methods.suma", data);
                System.out.println("Result -> " + response);
                break;
            case 4:
                //Díaz Hernández Andrés Yismael
                int temp, i, j;

                System.out.println("Hola, Ingresa un número");

                int [ ] array = new int [5];
                for(i=0; i<array.length; i++){
                    System.out.println("Dame el numero del indice "+i);
                    array[i]= read.nextInt( );
                }
                for(i = 0; i < array.length - 1; i++) {
                    for(j = 0; j < array.length - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            temp = array[j+1];
                            array[j+1] = array[j];
                            array[j] = temp;
                        }
                    }
                }
                String texto="";

                for (i = 0; i < array.length; i++) {
                    texto +=   "\nEl numero del índice " + i + " es " + array[i];

                }

                 data = new Object[]{texto};
                 response = (String) client.execute("Methods.arreglo", data);
                System.out.println("Result -> " + response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + practica);
        }
    }
}
