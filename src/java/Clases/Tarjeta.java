
package Clases;


public class Tarjeta {
    private int num_tarjeta;
    private int cvv;
    private int saldo;
    private String fecha_vencimiento;

    public Tarjeta() {
    }

    public Tarjeta(int num_tarjeta, int cvv, int saldo, String fecha) {
        this.num_tarjeta = num_tarjeta;
        this.cvv = cvv;
        this.saldo = saldo;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "num_tarjeta=" + num_tarjeta + ", cvv=" + cvv + ", saldo=" + saldo + ", fecha_vencimiento=" + fecha_vencimiento + '}';
    }
    
    
    
    
}
