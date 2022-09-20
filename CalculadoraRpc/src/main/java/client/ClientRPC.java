package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClientRPC {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String option = "", firsNumber = "", secondNumber = "";
        do {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Exponente");
            System.out.println("6. Raíz");
            System.out.println("7. Consultar historial");
            System.out.println("8. Salir");
            option = sc.next();
            if (isNumber(option)) {
                switch (Integer.parseInt(option)){
                    case 1:
                        System.out.println("SUMA");
                        do{
                            System.out.println("Ingrese el Primer numero");
                            firsNumber = sc.next();
                            if (!isDouble(firsNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firsNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data = {firsNumber, secondNumber};
                        double response = (double) client.execute("Methods.addition", data);
                        System.out.println("Result -> " + response);
                        break;
                    case 2:
                    System.out.println("RESTA");
                    do{
                        System.out.println("Ingrese el Primer numero");
                        firsNumber = sc.next();
                        if (!isDouble(firsNumber))
                            System.err.println("Ingrese un número válido. ");
                    }while (!isDouble(firsNumber));
                    do{
                        System.out.println("Ingrese el segundo numero");
                        secondNumber = sc.next();
                        if (!isDouble(secondNumber))
                            System.err.println("Ingrese un número válido. ");
                    }while (!isDouble(secondNumber));
                    //Ejecución del método en el servidor...
                    Object[] data2 = {firsNumber, secondNumber};
                    double response2 = (double) client.execute("Methods.subtraction", data2);
                    System.out.println("Result -> " + response2);
                    break;
                    case 3:
                        System.out.println("Multiplicacion");
                        do{
                            System.out.println("Ingrese el Primer numero");
                            firsNumber = sc.next();
                            if (!isDouble(firsNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firsNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data3 = {firsNumber, secondNumber};
                        double response3 = (double) client.execute("Methods.multiplication", data3);
                        System.out.println("Result -> " + response3);
                        break;
                    case 4:
                        System.out.println("Division");
                        do{
                            System.out.println("Ingrese el Primer numero");
                            firsNumber = sc.next();
                            if (!isDouble(firsNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firsNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data4 = {firsNumber, secondNumber};
                        double response4 = (double) client.execute("Methods.division", data4);
                        System.out.println("Result -> " + response4);
                        break;
                    case 5:
                        System.out.println("Exponente");
                        do{
                            System.out.println("Ingrese la base");
                            firsNumber = sc.next();
                            if (!isDouble(firsNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firsNumber));
                        do{
                            System.out.println("Ingrese el exponente");
                            secondNumber = sc.next();

                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data5 = {firsNumber, secondNumber};
                        double response5 = (double) client.execute("Methods.exponent", data5);
                        System.out.println("Result -> " + response5);
                        break;
                    case 6:
                        System.out.println("Raiz");
                        do{
                            System.out.println("Ingrese el numero");
                            firsNumber = sc.next();
                            if (!isDouble(firsNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firsNumber));
                        do{
                            System.out.println("Ingrese la raiz");
                            secondNumber = sc.next();

                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data6 = {firsNumber, secondNumber};
                        double response6 = (double) client.execute("Methods.root", data6);
                        System.out.println("Result -> " + response6);
                        break;

                    default:
                        System.out.println("No existe esa opción");
                }
            }else {
                System.out.println("La opción es incorrecta. Intente nuevamente");
            }
        } while (!option.equals("8"));
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
