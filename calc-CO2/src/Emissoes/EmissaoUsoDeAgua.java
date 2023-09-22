package Emissoes;

public class EmissaoUsoDeAgua {

	public double calcularFatorEmissaoCO2UsoDeAgua(double quantidadeAgua) {
	    double fatorEmissaoCO2 = 0.0;
	    double emissaoTotal = 0;
	    
	    if (quantidadeAgua > 0) {
	    	fatorEmissaoCO2 = 0.41;
	    } else {
	        throw new IllegalArgumentException("Não foi possível declarar o fator de emissão.");
	    }
	   
	    emissaoTotal = quantidadeAgua * fatorEmissaoCO2;
	    return emissaoTotal;
	}
}
