package Emissoes;

	public class EmissaoEnergiaEletrica {
		
	    public double calcularFatorEmissaoCO2ConsumoDeEnergia(double quantidadeEnergia, String tipoEnergiaEletrica) {
	        double fatorEmissaoCO2 = 0.0;
	        double emissaoTotal = 0;
	        
	        if (tipoEnergiaEletrica.equals("Carvão")) {
	            fatorEmissaoCO2 = 1.5;
	        } else if (tipoEnergiaEletrica.equals("Gás Natural")) {
	            fatorEmissaoCO2 = 0.4; 
	        } else if (tipoEnergiaEletrica.equals("Petróleo")) {
	            fatorEmissaoCO2 = 0.65; 
	        } else if (tipoEnergiaEletrica.equals("Nuclear")) {
	            fatorEmissaoCO2 = 0.025; 
	        } else if (tipoEnergiaEletrica.equals("Hidrelétrica")) {
	            fatorEmissaoCO2 = 0;
	        } else if (tipoEnergiaEletrica.equals("Eólica")) {
	            fatorEmissaoCO2 = 0; 
	        } else if (tipoEnergiaEletrica.equals("Solar")) {
	            fatorEmissaoCO2 = 0; 
	        } else if (tipoEnergiaEletrica.equals("Biomassa")) {
	            fatorEmissaoCO2 = 0.3;
	        } else {
		        throw new IllegalArgumentException("Não foi possível declarar o fator de emissão.");
		    }
	        
	        emissaoTotal = quantidadeEnergia * fatorEmissaoCO2;
	        return emissaoTotal;
	    }
	}