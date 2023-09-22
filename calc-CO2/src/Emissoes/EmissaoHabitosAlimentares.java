package Emissoes;

public class EmissaoHabitosAlimentares {
    
    public double calcularFatorEmissaoCO2HabitoAlimentar(String tipoAlimento, double quantidade) {
        double fatorEmissao = 0.0;
        double emissaoTotal = 0;
        
        if (tipoAlimento.equals("Carne bovina")) {
            fatorEmissao = 60.0;
        } else if (tipoAlimento.equals("Carne suína")) {
            fatorEmissao = 7.0;   
        } else if (tipoAlimento.equals("Frango")) {
            fatorEmissao = 6.0; 
        } else if (tipoAlimento.equals("Peixe Fresco")) {
            fatorEmissao = 5.0;  
        } else if (tipoAlimento.equals("Leite")) {
            fatorEmissao = 1.0;
        } else if (tipoAlimento.equals("Queijo")) {
            fatorEmissao = 13.5; 
        } else if (tipoAlimento.equals("Ovos")) {
            fatorEmissao = 4.75;
        } else if (tipoAlimento.equals("Arroz")) {
            fatorEmissao = 4.0; 
        } else if (tipoAlimento.equals("Trigo")) {
            fatorEmissao = 1.4; 
        } else if (tipoAlimento.equals("Feijão")) {
            fatorEmissao = 0.5; 
        } else if (tipoAlimento.equals("Batatas")) {
            fatorEmissao = 0.2;
        } else if (tipoAlimento.equals("Alface")) {
            fatorEmissao = 0.2;
        } else if (tipoAlimento.equals("Tomate")) {
            fatorEmissao = 0.3; 
        } else if (tipoAlimento.equals("Cenoura")) {
            fatorEmissao = 0.2; 
        } else if (tipoAlimento.equals("Maçãs")) {
            fatorEmissao = 0.2;   
        } else if (tipoAlimento.equals("Banana")) {
            fatorEmissao = 0.2;
        } else if (tipoAlimento.equals("Chocolate")) {
            fatorEmissao = 17.0;
        } else if (tipoAlimento.equals("Café")) {
            fatorEmissao = 16.0;
        } else {
            throw new IllegalArgumentException("Não foi possível declarar o fator de emissão.");
        }
        
        emissaoTotal = quantidade * fatorEmissao;
        return emissaoTotal;
    }
    
}
            
