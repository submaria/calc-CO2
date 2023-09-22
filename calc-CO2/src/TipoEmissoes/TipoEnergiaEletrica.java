package TipoEmissoes;

public class TipoEnergiaEletrica {
    private boolean carvao;
    private boolean gasNatural;
    private boolean petroleo;
    private boolean nuclear;
    private boolean hidreletrica;
    private boolean eolica;
    private boolean solar;
    private boolean biomassa;

    public TipoEnergiaEletrica(boolean carvao, boolean gasNatural, boolean petroleo, boolean nuclear,
            boolean hidreletrica, boolean eolica, boolean solar, boolean biomassa) {
        this.carvao = carvao;
        this.gasNatural = gasNatural;
        this.petroleo = petroleo;
        this.nuclear = nuclear;
        this.hidreletrica = hidreletrica;
        this.eolica = eolica;
        this.solar = solar;
        this.biomassa = biomassa;
    }

    public boolean IsCarvao() {
        return carvao;
    }

    public boolean IsGasNatural() {
        return gasNatural;
    }

    public boolean IsPetroleo() {
        return petroleo;
    }

    public boolean IsNuclear() {
        return nuclear;
    }

    public boolean IsHidreletrica() {
        return hidreletrica;
    }

    public boolean IsEolica() {
        return eolica;
    }

    public boolean IsSolar() {
        return solar;
    }

    public boolean IsBiomassa() {
        return biomassa;
    }
}
