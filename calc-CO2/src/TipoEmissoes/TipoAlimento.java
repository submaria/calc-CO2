package TipoEmissoes;

public class TipoAlimento {
    private boolean carneBovina;
    private boolean carneDePorco;
    private boolean frango;
    private boolean peixeFresco;
    private boolean leite;
    private boolean queijo;
    private boolean ovos;
    private boolean arroz;
    private boolean trigo;
    private boolean feijao;
    private boolean batatas;
    private boolean alface;
    private boolean tomate;
    private boolean cenoura;
    private boolean macas;
    private boolean banana;
    private boolean chocolate;
    private boolean cafe;

    public TipoAlimento(boolean carneBovina, boolean carneDePorco, boolean frango, boolean peixeFresco,
            boolean leite, boolean queijo, boolean ovos, boolean arroz, boolean trigo, boolean feijao,
            boolean batatas, boolean alface, boolean tomate, boolean cenoura, boolean macas, boolean banana,
            boolean chocolate, boolean cafe) {
        this.carneBovina = carneBovina;
        this.carneDePorco = carneDePorco;
        this.frango = frango;
        this.peixeFresco = peixeFresco;
        this.leite = leite;
        this.queijo = queijo;
        this.ovos = ovos;
        this.arroz = arroz;
        this.trigo = trigo;
        this.feijao = feijao;
        this.batatas = batatas;
        this.alface = alface;
        this.tomate = tomate;
        this.cenoura = cenoura;
        this.macas = macas;
        this.banana = banana;
        this.chocolate = chocolate;
        this.cafe = cafe;
    }

    public boolean IsCarneBovina() {
        return carneBovina;
    }

    public boolean IsCarneDePorco() {
        return carneDePorco;
    }

    public boolean IsFrango() {
        return frango;
    }

    public boolean IsPeixeFresco() {
        return peixeFresco;
    }

    public boolean IsLeite() {
        return leite;
    }

    public boolean IsQueijo() {
        return queijo;
    }

    public boolean IsOvos() {
        return ovos;
    }

    public boolean IsArroz() {
        return arroz;
    }

    public boolean IsTrigo() {
        return trigo;
    }

    public boolean IsFeijao() {
        return feijao;
    }

    public boolean IsBatatas() {
        return batatas;
    }

    public boolean IsAlface() {
        return alface;
    }

    public boolean IsTomate() {
        return tomate;
    }

    public boolean IsCenoura() {
        return cenoura;
    }

    public boolean IsMacas() {
        return macas;
    }

    public boolean IsBanana() {
        return banana;
    }

    public boolean IsChocolate() {
        return chocolate;
    }

    public boolean IsCafe() {
        return cafe;
    }
}

