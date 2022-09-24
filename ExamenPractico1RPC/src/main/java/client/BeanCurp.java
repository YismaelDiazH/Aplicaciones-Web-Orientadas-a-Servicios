package client;

public class BeanCurp {
private int Id;
private String Nombre;
private String Apellido_Paterno;
private String Apellido_Materno;
private String Estado_Nacimiento;
private String Sexo;
private String curp;
private String Fecha_Nacimiento;
    public BeanCurp() {
    }

    public BeanCurp(int id, String nombre, String apellido_Paterno, String apellido_Materno, String estado_Nacimiento, String sexo, String curp, String fecha_Nacimiento) {
        Id = id;
        Nombre = nombre;
        Apellido_Paterno = apellido_Paterno;
        Apellido_Materno = apellido_Materno;
        Estado_Nacimiento = estado_Nacimiento;
        Sexo = sexo;
        this.curp = curp;
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        Apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        Apellido_Materno = apellido_Materno;
    }

    public String getEstado_Nacimiento() {
        return Estado_Nacimiento;
    }

    public void setEstado_Nacimiento(String estado_Nacimiento) {
        Estado_Nacimiento = estado_Nacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }
}
