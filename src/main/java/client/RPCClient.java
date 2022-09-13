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

        Object[] data = {texto};
        String response = (String) client.execute("Methods.arreglo", data);
        System.out.println("Result -> " + response);





    }
}
