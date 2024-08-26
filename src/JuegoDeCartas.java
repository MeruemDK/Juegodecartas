import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ingresar el número de jugadores
        System.out.println("Ingrese el número de jugadores");
        int numJugadores = sc.nextInt();

        //Ingresar el número de partidas
        System.out.println("Ingrese el número de partidas o rondas");
        int numPartidas = sc.nextInt();

        Juego juego = new Juego(numJugadores, numPartidas);
        juego.jugar();
    }
}
