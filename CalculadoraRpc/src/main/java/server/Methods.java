package server;

public class Methods {
    public double addition(String n1, String n2){
        double suma = Double.parseDouble(n1) + Double.parseDouble(n2);
        return suma;
    }
    public double subtraction(String n1, String n2){
        double subtra = (Double.parseDouble(n1) - Double.parseDouble(n2));
        return subtra;
    }

    public double multiplication(String n1, String n2){
        double multi = Double.parseDouble(n1) * Double.parseDouble(n2);
        return multi;
    }

    public double division(String n1, String n2){
        double divi = Double.parseDouble(n1) / Double.parseDouble(n2);
        return divi;
    }
    public double exponent(String n1, String n2){
        double expo =  Math.pow(Double.parseDouble(n1),Double.parseDouble(n2));
        return expo;
    }
    public double root(String n1, String n2){
        double root =  Math.pow(Double.parseDouble(n1),1.0/Double.parseDouble(n2));
        return root;
    }

}
