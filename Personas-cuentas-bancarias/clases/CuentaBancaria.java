package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    //Atributos
    private double saldo;
    private Persona titular;
    private int numeroCuenta;

    //Lista estática donde se guardan todas las instancias de cuenta bancaria
    private static ArrayList<CuentaBancaria> listaDCuentaBancarias = new ArrayList<>();


    //Constructor
    public CuentaBancaria(double saldo, Persona titular){
        this.saldo = saldo;
        this.titular = titular;
        this.numeroCuenta = generarNumeroCuenta();
        listaDCuentaBancarias.add(this);
    }

    //Getters y Setters - generado con atajo
   
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    //Generar número de cuenta de 6 dígitos
    private int generarNumeroCuenta(){
        Random random = new Random();
        int numeroCuenta = 100000 + random.nextInt(900000);
        return numeroCuenta;
    }

    //Métodos de deposito, retiro y desplegar información (una cuenta y de todas las cuentas)
    public void depositar(double monto){
        if(monto > 0){
            saldo += monto;
            System.out.println("Deposito realizado de forma exitosa, por el monto de $" + monto);
        }else{
            System.out.println("Monto no válido para deposito");
        }
    }

    public void retirar(double monto){
        if(monto > 0 && monto <= saldo){
            saldo-= monto;
            System.out.println("Retiro realizado de forma exitosa, por el monto de $" + monto);
        }else if (monto > saldo) {
            System.out.println("Fondos insuficientes");
        }else{
            System.out.println("Monto no válido para retiro");
        }
    }

    //Método para mostrar la información de esa cuenta
    public void despliegaInformacion(){
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular de cuenta: " + titular.getNombre() + " edad: " + titular.getEdad());
        System.out.println("Saldo de la cuenta: " + saldo);
    }

    //Método para mostrar la información de todas las cuentas bancarias
    public static void imprimeInformacionDeTodasLasCuentas(){
        for(CuentaBancaria cuenta : listaDCuentaBancarias){
            cuenta.despliegaInformacion();
            System.out.println("-----------------");
        }
        
}

}