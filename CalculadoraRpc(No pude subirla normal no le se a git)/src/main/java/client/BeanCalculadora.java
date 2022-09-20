package client;

import java.util.Date;

public class BeanCalculadora {
private int id;
private String type;
private double first_number;
private double second_number;
private double result;
private Date created_at;

    public BeanCalculadora() {
    }

    public BeanCalculadora(int id, String type, double first_number, double second_number, double result, Date created_at) {
        this.id = id;
        this.type = type;
        this.first_number = first_number;
        this.second_number = second_number;
        this.result = result;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BeanCalculadora{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", first_number=" + first_number +
                ", second_number=" + second_number +
                ", result=" + result +
                ", created_at=" + created_at +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFirst_number() {
        return first_number;
    }

    public void setFirst_number(double first_number) {
        this.first_number = first_number;
    }

    public double getSecond_number() {
        return second_number;
    }

    public void setSecond_number(double second_number) {
        this.second_number = second_number;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
