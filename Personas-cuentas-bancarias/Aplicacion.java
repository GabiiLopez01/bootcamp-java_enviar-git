import clases.CuentaBancaria;
import clases.Persona;

public class Aplicacion {
   public static void main(String[] args) {
      
    //Instancias de la clase persona
      Persona persona1 = new Persona("Un nombre", 25);
      Persona persona2 = new Persona("Otra persona", 28);
      Persona persona3 = new Persona ("Gabriela", 30);
      
    //Instancias de cuentas bancarias  
      CuentaBancaria cuenta1 = new CuentaBancaria(1000.0, persona1);
      CuentaBancaria cuenta2 = new CuentaBancaria(2000.0, persona2);
      CuentaBancaria cuenta3 = new CuentaBancaria(2800.0, persona3);

    //Operaciones y saldo de cuentas
      cuenta1.depositar(500.0);
      System.out.println(cuenta1.getSaldo());
      cuenta1.retirar(100.0);
      System.out.println(cuenta1.getSaldo());
      System.out.println("-----------------");
      
      cuenta2.depositar(250.0);
      System.out.println(cuenta2.getSaldo());
      cuenta2.retirar(300.0);
      System.out.println(cuenta2.getSaldo());
      System.out.println("-----------------");
      
      cuenta3.depositar(1000.0);
      System.out.println(cuenta3.getSaldo());
      cuenta3.retirar(4000.0);
      System.out.println(cuenta3.getSaldo());
      System.out.println("-----------------");
      

    
    CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
   }
}