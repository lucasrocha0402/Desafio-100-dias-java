import java.security.SecureRandom;

public class Dia1 {

    public static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static void main(String[] arg) {
        System.out.println("Gerando um numero entre 50 e 100");
        System.out.println( randomNumberBetween (50, 100));
    }

    private static int randomNumberBetween ( int minimo , int maximo) {
        return SECURE_RANDOM . nextInt( maximo - minimo ) + minimo;
    }

}
