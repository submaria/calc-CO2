package Emissoes;

public class ExtrairEmissaoTotal {

	public double extrairValorNumerico(String texto) {
	    if (texto.contains("Emissão CO2:")) {
	        String valorNumerico = texto.substring(texto.indexOf("Emissão CO2:") + 12);
	        
	        valorNumerico = valorNumerico.trim();
	        
	        valorNumerico = valorNumerico.replaceAll("[^\\d.,]", "");
	        
	        valorNumerico = valorNumerico.replace(",", ".");
	        
	        try {
	            return Double.parseDouble(valorNumerico);
	        } catch (NumberFormatException e) {
	        	throw new RuntimeException("Não foi possível extrair um valor numérico válido: " + texto);
	        }
	    }
	    
	    return 0.0;
	}

}