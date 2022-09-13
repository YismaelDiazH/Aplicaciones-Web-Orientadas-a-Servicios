package server;

public class Methods {
    //Díaz Hernández Andrés Yismael
    public String producto(double producto, double suma, double promedio){
        return "Hola, el producto es: "+ producto + " , la suma es:  " + suma + " y el promedio es: " + promedio;
    }
    public String person(String nombre, double peso, double altura){
        return "Hola "+ nombre + " tu IMC es " + peso / (altura*altura);
    }
    public String arreglo(String texto) {
        return texto;

    }
    public String suma(double suma){
        return "Hola, El resultado es: " + suma;
    }
}
