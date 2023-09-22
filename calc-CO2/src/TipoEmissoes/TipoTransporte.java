package TipoEmissoes;

public class TipoTransporte {
    private boolean carroDePasseio;
    private boolean onibusUrbano;
    private boolean metroOuTrem;

    public TipoTransporte(boolean carroDePasseio, boolean onibusUrbano, boolean metroOuTrem) {
        this.carroDePasseio = carroDePasseio;
        this.onibusUrbano = onibusUrbano;
        this.metroOuTrem = metroOuTrem;
    }

    public boolean IsCarroDePasseio() {
        return carroDePasseio;
    }

    public boolean IsOnibusUrbano() {
        return onibusUrbano;
    }

    public boolean IsMetroOuTrem() {
        return metroOuTrem;
    }
}