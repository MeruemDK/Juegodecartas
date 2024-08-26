public class Cartas {
    private String valor; //El valor que tiene la carta, sea As, 2, 3, 4...
    private String simbolo; //Corazones, Espadas, Trébol y Diamante

    // Método constructor
    // Método utilizado al instanciar un objeto a la clase Cartas
    public Cartas(String valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    //Obtiene el valor de la carta
    public String getValor() {
        return valor;
    }

    //Obtiene el símbolo de la carta
    public String getSimbolo() {
        return simbolo;
    }

    public int getValorNumerico(){
        switch (valor){
            case "As": //Valor numérico devuelto para el As
                return 11;
            case "J": //Valor numérico devuelto para J, Q y K
            case "Q":
            case "K":
                return 10;
            default: //Valor numérico para las cartas que tienen números
                return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString(){
        return valor + " de " + simbolo;
    }
}
