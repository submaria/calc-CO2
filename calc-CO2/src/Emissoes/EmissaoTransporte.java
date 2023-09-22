package Emissoes;

public class EmissaoTransporte {

	public double calcularFatorEmissaoCO2Transporte(String tipoTransporte, String tipoCombustivel, double distancia, double consumoCombustivel) {
	    
		double fatorEmissaoCO2 = 0.0;
	    double emissaoTotal = 0;
	    
	    if (tipoTransporte.equals("Carro de Passeio")) {
	        if (tipoCombustivel.equals("Gasolina"))
	            fatorEmissaoCO2 = 2.3;
	        else if (tipoCombustivel.equals("Diesel"))
	            fatorEmissaoCO2 = 2.7;
	        else if (tipoCombustivel.equals("Etanol"))
	            fatorEmissaoCO2 = 1.9;
	        else if (tipoCombustivel.equals("Elétrico"))
	            fatorEmissaoCO2 = 0.2;
	    } else if (tipoTransporte.equals("Ônibus Urbano")) {
	        fatorEmissaoCO2 = 0.68;
	    } else if (tipoTransporte.equals("Metrô/Trem")) {
	        fatorEmissaoCO2 = 0.06;
	    } else {
	        throw new IllegalArgumentException("Não foi possível declarar o fator de emissão.");
	    }

	    if (!tipoTransporte.equals("Carro de Passeio")) {
	    	emissaoTotal = distancia * fatorEmissaoCO2;    
	    }else {
	    	emissaoTotal = distancia * consumoCombustivel * fatorEmissaoCO2;
	    }
	    
		return emissaoTotal;
		
	}
	
}
