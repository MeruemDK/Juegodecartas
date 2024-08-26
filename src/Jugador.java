import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private float saldo;
    private int punteo;
    private List<Cartas> cartas;
    private Cartas cartaActual;
    private int totalPuntos;

    public Jugador(String nombre, float saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.punteo = 0;
        this.cartas = new ArrayList<>();
        this.cartaActual = null;
        this.totalPuntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cartas> getCartas() {
        return cartas;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void sumarPuntos(int puntos) {
        this.totalPuntos += puntos;
    }

    public void agregarCarta(Cartas carta) {
        cartas.add(carta);
    }

    public Cartas jugarCarta() {
        Random random = new Random();
        int indiceCarta = random.nextInt(cartas.size());
        return cartas.remove(indiceCarta);
    }

    // Resto del código...
}
