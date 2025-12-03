import clases.Algoritmos;

public class Aplicacion {
   public static void main(String[] args) {
      System.out.println("Prueba esPar");
      int numPar = 10;
      int numImpar = 7;
      System.out.println(numPar + " es par: " + Algoritmos.esPar(numPar));
      System.out.println(numImpar + " es par: " + Algoritmos.esPar(numImpar));

      System.out.println("Prueba esPrimo");
      int primo = 17;
      int noPrimo = 9;
      System.out.println(primo + " es primo: " + Algoritmos.esPrimo(primo));
      System.out.println(noPrimo + " es primo: " + Algoritmos.esPrimo(noPrimo));

      System.out.println("Prueba stringEnReversa");
      String textoOriginal = "Hola Java";
      System.out.println("Original: " + textoOriginal);
      System.out.println("Reversa: " + Algoritmos.stringEnReversa(textoOriginal));

      System.out.println("Prueba esPalindromo");
      String pal1 = "radar";
      String pal2 = "Oso";
      System.out.println(pal1 + "' es palindromo: " + Algoritmos.esPalindromo(pal1));
      System.out.println(pal2 + "' es palindromo: " + Algoritmos.esPalindromo(pal2));
      System.out.println("'Algorimo' es palindromo: " + Algoritmos.esPalindromo("Algorimos"));


      System.out.println("Prueba secuenciaFizzBuzz");
      int limite = 15;
      System.out.println("Secuencia FizzBuzz hasta " + limite + ":");
      Algoritmos.secuenciaFizzBuzz(limite);
   }
}