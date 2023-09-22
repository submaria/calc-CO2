package TipoEmissoes;

public class TipoCombustivel {
    private boolean gasolina;
    private boolean disel;
    private boolean etanol;
    private boolean eletrico;

    public TipoCombustivel(boolean gasolina, boolean disel, boolean etanol, boolean eletrico) {
        this.gasolina = gasolina;
        this.disel = disel;
        this.etanol = etanol;
        this.eletrico = eletrico;
    }

    public boolean IsGasolina() {
        return gasolina;
    }

    public boolean IsDisel() {
        return disel;
    }

    public boolean IsEtanol() {
        return etanol;
    }

    public boolean IsEletrico() {
        return eletrico;
    }
}
