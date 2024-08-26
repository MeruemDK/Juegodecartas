import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;
    private List<Cartas> cartas;
    private int numeroRondas;

    // Constructor
    public Juego(int numeroJugadores, int numeroRondas) {
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
    }

    // Método para crear jugadores
    private List<Jugador> crearJugadores(int numeroJugadores) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador" + (i + 1), 50));
        }
        return jugadores;
    }

    // Método para crear la baraja de cartas
    public List<Cartas> crearBaraja() {
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazón", "Diamante", "Trébol", "Espadas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                Cartas carta = new Cartas(valor, simbolo);
                baraja.add(carta);
            }
        }
        return baraja;
    }

    // Método para barajar las cartas
    private void barajar() {
        Collections.shuffle(cartas);
    }

    // Método para repartir las cartas
    private void repartirCartas() {
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 5; i++) {
                jugador.agregarCarta(cartas.remove(0));
            }
        }
    }

    private void mostrarCartas() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }
    }

    // Método para jugar una carta
    private void jugarCarta() {
        for (Jugador jugador : jugadores) {
            Cartas cartaJugando = jugador.jugarCarta();
            int valorCarta = cartaJugando.getValorNumerico();
            jugador.sumarPuntos(valorCarta);
            System.out.println("Jugador " + jugador.getNombre() + " jugó " + cartaJugando + " con valor " + valorCarta);
        }
    }


    // Método principal para jugar el juego
    public void jugar() {
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            jugarCarta();
        }

        // Determinar el ganador al final de todas las rondas
        Jugador ganador = null;
        int maxPuntos = 0;
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene un total de " + jugador.getTotalPuntos() + " puntos.");
            if (jugador.getTotalPuntos() > maxPuntos) {
                maxPuntos = jugador.getTotalPuntos();
                ganador = jugador;
            }
        }

        if (ganador != null) {
            System.out.println("El ganador es " + ganador.getNombre() + " con " + maxPuntos + " puntos.");
        } else {
            System.out.println("Hubo un empate.");
        }
    }
}
