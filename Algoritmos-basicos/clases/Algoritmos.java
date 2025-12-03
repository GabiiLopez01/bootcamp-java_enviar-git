package clases;

public class Algoritmos {
   public Algoritmos() {
   }

   public static boolean esPar(int numero) {
      return numero % 2 == 0;
   }

   public static boolean esPrimo(int numero) {
      if (numero <= 1) {
         return false;
      } else {
         for(int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
               return false;
            }
         }

         return true;
      }
   }

   public static String stringEnReversa(String texto) {
      String textoReversa = "";

      for(int i = texto.length() - 1; i >= 0; i --) {
         textoReversa += texto.charAt(i);
      }

      return textoReversa;
   }

   public static boolean esPalindromo(String texto) {
      String textoReverso = stringEnReversa(texto);
      return texto.equals(textoReverso);
   }

   public static void secuenciaFizzBuzz(int limite) {
      for(int i = 1; i <= limite; i++) {
         String resultado = "";
         if (i % 3 == 0 && i % 5 == 0) {
            resultado = "FizzBuzz";
         } else if (i % 3 == 0) {
            resultado = "Fizz";
         } else if (i % 5 == 0) {
            resultado = "Buzz";
         } else {
            resultado = String.valueOf(i);
         }

         System.out.print(resultado + " ");
      }

   }
}