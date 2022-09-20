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
        DaoCalculadora dao = new DaoCalculadora();
        BeanCalculadora bean = new BeanCalculadora();
        String option = "", firstNumber = "", secondNumber = "";
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
                        bean.setType("SUMA");
                        do{
                            System.out.println("Ingrese el Primer numero");
                            firstNumber = sc.next();
                            bean.setFirst_number(Double.parseDouble(firstNumber));
                            if (!isDouble(firstNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firstNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            bean.setSecond_number(Double.parseDouble(secondNumber));
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data = {firstNumber, secondNumber};
                        double response = (double) client.execute("Methods.addition", data);
                        System.out.println("Result -> " + response);
                        bean.setResult(response);
                        dao.saveAOperacion(bean);
                        break;
                    case 2:
                    System.out.println("RESTA");
                        bean.setType("RESTA");

                        do{
                        System.out.println("Ingrese el Primer numero");
                        firstNumber = sc.next();
                        bean.setFirst_number(Double.parseDouble(firstNumber));

                        if (!isDouble(firstNumber))
                            System.err.println("Ingrese un número válido. ");
                    }while (!isDouble(firstNumber));
                    do{
                        System.out.println("Ingrese el segundo numero");
                        secondNumber = sc.next();
                        bean.setSecond_number(Double.parseDouble(secondNumber));
                        if (!isDouble(secondNumber))
                            System.err.println("Ingrese un número válido. ");
                    }while (!isDouble(secondNumber));
                    //Ejecución del método en el servidor...
                    Object[] data2 = {firstNumber, secondNumber};
                    double response2 = (double) client.execute("Methods.subtraction", data2);
                    System.out.println("Result -> " + response2);
                        bean.setResult(response2);
                        dao.saveAOperacion(bean);
                    break;
                    case 3:
                        System.out.println("Multiplicacion");
                        bean.setType("MULTIPLICACION");

                        do{
                            System.out.println("Ingrese el Primer numero");
                            firstNumber = sc.next();
                            bean.setFirst_number(Double.parseDouble(firstNumber));

                            if (!isDouble(firstNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firstNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            bean.setSecond_number(Double.parseDouble(secondNumber));
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data3 = {firstNumber, secondNumber};
                        double response3 = (double) client.execute("Methods.multiplication", data3);
                        System.out.println("Result -> " + response3);
                        bean.setResult(response3);
                        dao.saveAOperacion(bean);
                        break;
                    case 4:
                        System.out.println("Division");
                        bean.setType("DIVISION");

                        do{
                            System.out.println("Ingrese el Primer numero");
                            firstNumber = sc.next();
                            bean.setFirst_number(Double.parseDouble(firstNumber));

                            if (!isDouble(firstNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firstNumber));
                        do{
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = sc.next();
                            bean.setSecond_number(Double.parseDouble(secondNumber));
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data4 = {firstNumber, secondNumber};
                        double response4 = (double) client.execute("Methods.division", data4);
                        System.out.println("Result -> " + response4);
                        bean.setResult(response4);
                        dao.saveAOperacion(bean);
                        break;
                    case 5:
                        System.out.println("Exponente");
                        bean.setType("EXPONENTE");

                        do{
                            System.out.println("Ingrese la base");
                            firstNumber = sc.next();
                            bean.setFirst_number(Double.parseDouble(firstNumber));

                            if (!isDouble(firstNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firstNumber));
                        do{
                            System.out.println("Ingrese el exponente");
                            secondNumber = sc.next();
                            bean.setSecond_number(Double.parseDouble(secondNumber));
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data5 = {firstNumber, secondNumber};
                        double response5 = (double) client.execute("Methods.exponent", data5);
                        System.out.println("Result -> " + response5);
                        bean.setResult(response5);
                        dao.saveAOperacion(bean);
                        break;
                    case 6:
                        System.out.println("Raiz");
                        bean.setType("RAIZ");

                        do{
                            System.out.println("Ingrese el numero");
                            firstNumber = sc.next();
                            bean.setFirst_number(Double.parseDouble(firstNumber));

                            if (!isDouble(firstNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(firstNumber));
                        do{
                            System.out.println("Ingrese la raiz");
                            secondNumber = sc.next();
                            bean.setSecond_number(Double.parseDouble(secondNumber));
                            if (!isDouble(secondNumber))
                                System.err.println("Ingrese un número válido. ");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor...
                        Object[] data6 = {firstNumber, secondNumber};
                        double response6 = (double) client.execute("Methods.root", data6);
                        System.out.println("Result -> " + response6);
                        bean.setResult(response6);
                        dao.saveAOperacion(bean);
                        break;
                    case 7:
                        System.out.println("CONSULTA DE HISTORIAL");
                        System.out.println(bean.toString());

                        break;
                    case 8:
                        System.out.println("saliendo...");
                        break;
                    default:
                        System.out.println("Eso no existe...");
                        break;
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
