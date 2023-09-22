import javax.swing.*;

import TipoEmissoes.TipoAlimento;
import TipoEmissoes.TipoCombustivel;
import TipoEmissoes.TipoEnergiaEletrica;
import TipoEmissoes.TipoTransporte;

import Emissoes.ExtrairEmissaoTotal;
import Emissoes.EmissaoHabitosAlimentares;
import Emissoes.EmissaoEnergiaEletrica;
import Emissoes.EmissaoUsoDeAgua;
import Emissoes.EmissaoTransporte;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class APS extends JFrame {

	private JComboBox<String> comboBoxPanels;
    private JPanel panelContainer;
    private JPanel panelEnergiaEletrica;
    private JPanel panelHabitosAlimentares;
    private JPanel panelTransporte;
    private JPanel panelUsoAgua;
    private Map<String, Integer> panelOptions;
    private JPanel panelExtrairEmissao;

    private JList<String> listConsumoEnergia;
    private DefaultListModel<String> listModelConsumoEnergia;
    private JScrollPane scrollPaneConsumoEnergia;
    private JButton buttonAdicionarConsumoEnergia;

    private JList<String> listHabitosAlimentares; 
    private DefaultListModel<String> listModelHabitosAlimentares;
    private JScrollPane scrollPaneHabitosAlimentares;
    private JButton buttonAdicionarHabitoAlimentar;

    private JComboBox<String> comboBoxTipoTransporte;
    private JTextField textFieldConsumoCombustivel;
    private JComboBox<String> comboBoxTipoCombustivel;
    private JTextField textFieldDistancia;
    private JList<String> listTransporte; 
    private DefaultListModel<String> listModelTransporte;
    private JScrollPane scrollPaneTransporte;
    private JButton buttonAdicionarTransporte;
    
    private JList<String> listConsumoAgua; 
    private DefaultListModel<String> listModelConsumoAgua;
    private JScrollPane scrollPaneConsumoAgua;
    private JButton buttonAdicionarConsumoAgua;
    
    private double Valor;

    public APS() {
    	
        super("Calculadora de Emissão de CO2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400,300);
        getContentPane().setLayout(new BorderLayout());

        createComponents();

        comboBoxPanels = new JComboBox<>();

        panelOptions = new HashMap<>();
        panelOptions.put("Gasto de Energia Elétrica", 1);
        panelOptions.put("Hábitos Alimentares", 2);
        panelOptions.put("Transporte", 3);
        panelOptions.put("Uso de Água", 4);

        for (String panelOption : panelOptions.keySet()) {
            comboBoxPanels.addItem(panelOption);
        }

        comboBoxPanels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSelectedPanel();
            }
        });

        JPanel panelComboBox = new JPanel(new FlowLayout());
        panelComboBox.add(new JLabel("Selecione a opção:"));
        panelComboBox.add(comboBoxPanels);

        panelContainer = new JPanel(new CardLayout());
        panelContainer.add(panelEnergiaEletrica, "Gasto de Energia Elétrica");
        panelContainer.add(panelHabitosAlimentares, "Hábitos Alimentares");
        panelContainer.add(panelTransporte, "Transporte");
        panelContainer.add(panelUsoAgua, "Uso de Água");

        JButton buttonCalcularSoma = new JButton("Calcular Soma");
        buttonCalcularSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ExtrairEmissaoTotal extrairEmissao = new ExtrairEmissaoTotal();
            	double total = 0.0;

                for (int i = 0; i < listModelConsumoAgua.size(); i++) {
                    String item = listModelConsumoAgua.getElementAt(i);
                    double emissao = extrairEmissao.extrairValorNumerico(item);
                    total += emissao;
                }

                for (int i = 0; i < listModelConsumoEnergia.size(); i++) {
                    String item = listModelConsumoEnergia.getElementAt(i);
                    double emissao = extrairEmissao.extrairValorNumerico(item);
                    total += emissao;
                }

                for (int i = 0; i < listModelHabitosAlimentares.size(); i++) {
                    String item = listModelHabitosAlimentares.getElementAt(i);
                    double emissao = extrairEmissao.extrairValorNumerico(item);
                    total += emissao;
                }

                for (int i = 0; i < listModelTransporte.size(); i++) {
                    String item = listModelTransporte.getElementAt(i);
                    double emissao = extrairEmissao.extrairValorNumerico(item);
                    total += emissao;
                }

                JOptionPane.showMessageDialog(null, "A soma total de emissões é: " + total + " kg");
            }
        });
        
        JButton buttonRemover = new JButton("Remover");
        buttonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItemSelecionado();
            }
        });

        panelExtrairEmissao = new JPanel(new FlowLayout());
        panelExtrairEmissao.add(buttonCalcularSoma, BorderLayout.SOUTH);
        panelExtrairEmissao.add(buttonRemover, BorderLayout.SOUTH);
                
        getContentPane().add(panelComboBox, BorderLayout.NORTH);
        getContentPane().add(panelContainer, BorderLayout.CENTER);
        getContentPane().add(panelExtrairEmissao, BorderLayout.SOUTH);
        getContentPane().add(panelExtrairEmissao, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        
    }
    
    private void removerItemSelecionado() {
        int indexTransporte = listTransporte.getSelectedIndex();
        int indexConsumoAgua = listConsumoAgua.getSelectedIndex();
        int indexHabitosAlimentares = listHabitosAlimentares.getSelectedIndex();
        int indexConsumoEnergia = listConsumoEnergia.getSelectedIndex();

        if (indexTransporte != -1) {
            listModelTransporte.remove(indexTransporte);
        }

        if (indexConsumoAgua != -1) {
            listModelConsumoAgua.remove(indexConsumoAgua);
        }

        if (indexHabitosAlimentares != -1) {
            listModelHabitosAlimentares.remove(indexHabitosAlimentares);
        }
        
        if (indexConsumoEnergia != -1) {
            listModelConsumoEnergia.remove(indexConsumoEnergia);
        }
    }

    private void createComponents() {
        panelEnergiaEletrica = createPanelEnergiaEletrica();
        panelHabitosAlimentares = createPanelHabitosAlimentares();
        panelTransporte = createPanelTransporte();
        panelUsoAgua = createPanelUsoAgua();
        }
    
    private void showSelectedPanel() {
        String selectedPanel = (String) comboBoxPanels.getSelectedItem();
        CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
        cardLayout.show(panelContainer, selectedPanel);
    }
    
    private JPanel createPanelEnergiaEletrica() {
    	JPanel panel = new JPanel(new BorderLayout());

        listModelConsumoEnergia = new DefaultListModel<>();
        listConsumoEnergia = new JList<>(listModelConsumoEnergia);
        scrollPaneConsumoEnergia = new JScrollPane(listConsumoEnergia);

        buttonAdicionarConsumoEnergia = new JButton("Adicionar");

        buttonAdicionarConsumoEnergia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	adicionarConsumoDeEnergia();
            }
        });

        panel.add(new JLabel("Consumo de Energia:"), BorderLayout.NORTH);
        panel.add(scrollPaneConsumoEnergia, BorderLayout.CENTER);
        panel.add(buttonAdicionarConsumoEnergia, BorderLayout.SOUTH);

        return panel;
    }

    private void adicionarConsumoDeEnergia() {
        EmissaoEnergiaEletrica consumoEnergiaEletrica = new EmissaoEnergiaEletrica();
        
        String[] tiposEnergiaEletrica = {
            "Carvão", "Gás Natural", "Petróleo", "Nuclear", "Hidrelétrica", "Eólica", "Solar", "Biomassa"
        };
        
        JComboBox<String> comboBoxTipoEnergiaEletrica = new JComboBox<>(tiposEnergiaEletrica);
        JTextField textFieldQuantidadeEnergia = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Tipo de Energia Elétrica:"));
        panel.add(comboBoxTipoEnergiaEletrica);
        panel.add(new JLabel("Quantidade de Energia (kWh):"));
        panel.add(textFieldQuantidadeEnergia);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Consumo de Energia",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String tipoEnergiaEletrica = (String) comboBoxTipoEnergiaEletrica.getSelectedItem();
            double quantidadeEnergia = Double.parseDouble(textFieldQuantidadeEnergia.getText());

            double emissaoCO2 = consumoEnergiaEletrica.calcularFatorEmissaoCO2ConsumoDeEnergia(quantidadeEnergia, tipoEnergiaEletrica);

            String habitoConsumoEnergia = tipoEnergiaEletrica + " - " + quantidadeEnergia + " kWh - Emissão CO2: " + emissaoCO2 + " kg";
            listModelConsumoEnergia.addElement(habitoConsumoEnergia);
        }
    }
    
    private JPanel createPanelHabitosAlimentares() {
        JPanel panel = new JPanel(new BorderLayout());

        listModelHabitosAlimentares = new DefaultListModel<>();
        listHabitosAlimentares = new JList<>(listModelHabitosAlimentares);
        scrollPaneHabitosAlimentares = new JScrollPane(listHabitosAlimentares);

        buttonAdicionarHabitoAlimentar = new JButton("Adicionar");

        buttonAdicionarHabitoAlimentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarHabitosAlimentares();
            }
        });

        panel.add(new JLabel("Hábitos alimentares:"), BorderLayout.NORTH);
        panel.add(scrollPaneHabitosAlimentares, BorderLayout.CENTER);
        panel.add(buttonAdicionarHabitoAlimentar, BorderLayout.SOUTH);

        return panel;
    }

    private void adicionarHabitosAlimentares() {
        EmissaoHabitosAlimentares habitosAlimentares = new EmissaoHabitosAlimentares();
        
        String[] tiposAlimentos = {
            "Carne bovina", "Carne suína", "Frango", "Peixe Fresco", "Leite", "Queijo",
            "Ovos", "Arroz", "Trigo", "Feijão", "Batatas", "Alface", "Tomate", 
            "Cenoura", "Maças", "Banana", "Chocolate", "Café"
        };
        
        JComboBox<String> comboBoxTipoAlimento = new JComboBox<>(tiposAlimentos);
        JTextField textFieldQuantidade = new JTextField(10);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Tipo de Alimento:"));
        panel.add(comboBoxTipoAlimento);
        panel.add(new JLabel("Quantidade (Kg/L):"));
        panel.add(textFieldQuantidade);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Hábito Alimentar",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String tipoAlimento = (String) comboBoxTipoAlimento.getSelectedItem();
            double quantidade = Double.parseDouble(textFieldQuantidade.getText());
            
            double emissaoCO2 = habitosAlimentares.calcularFatorEmissaoCO2HabitoAlimentar(tipoAlimento, quantidade);
            
            String habitoAlimentar = tipoAlimento + " - " + quantidade + " g - Emissão CO2: " + emissaoCO2 + " kg";
            listModelHabitosAlimentares.addElement(habitoAlimentar);
        }
    }
    
    private JPanel createPanelTransporte() {
        JPanel panel = new JPanel(new BorderLayout());

        listModelTransporte = new DefaultListModel<>();
        listTransporte = new JList<>(listModelTransporte);
        scrollPaneTransporte = new JScrollPane(listTransporte);

        buttonAdicionarTransporte = new JButton("Adicionar");

        buttonAdicionarTransporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTransporte();
            }
        });

        panel.add(new JLabel("Transportes:"), BorderLayout.NORTH);
        panel.add(scrollPaneTransporte, BorderLayout.CENTER);
        panel.add(buttonAdicionarTransporte, BorderLayout.SOUTH);
       
        return panel;
    }
    
    private void adicionarTransporte() {
    	EmissaoTransporte transporte = new EmissaoTransporte();
        String[] tiposTransporte = {
            "Carro de Passeio", "Ônibus Urbano", "Metrô/Trem"
        };

        String[] tiposCombustivel = {
            "Gasolina", "Diesel", "Etanol", "Elétrico", "Sem Combustível Definido"
        };

        comboBoxTipoTransporte = new JComboBox<>(tiposTransporte);
        textFieldDistancia = new JTextField(10);
        comboBoxTipoCombustivel = new JComboBox<>(tiposCombustivel);
        textFieldConsumoCombustivel = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Tipo de Transporte:"));
        panel.add(comboBoxTipoTransporte);
        panel.add(new JLabel("Distância percorrida (Km):"));
        panel.add(textFieldDistancia);
        panel.add(new JLabel("Tipo de Combustível:"));
        panel.add(comboBoxTipoCombustivel);
        panel.add(new JLabel("Consumo de combustível (Litros):"));
        panel.add(textFieldConsumoCombustivel);
           
        comboBoxTipoTransporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCamposTransporte();
            }
        });

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Hábito de Transporte",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String tipoTransporte = (String) comboBoxTipoTransporte.getSelectedItem();
            String tipoCombustivel = (String) comboBoxTipoCombustivel.getSelectedItem();
            
            double emissaoCO2 = 0;
            double distancia = Double.parseDouble(textFieldDistancia.getText());
            String habitoTransporte;
            
            if (tipoTransporte.equals("Ônibus Urbano") || tipoTransporte.equals("Metrô/Trem")) {
                double consumoCombustivel = 0;
                emissaoCO2 = transporte.calcularFatorEmissaoCO2Transporte(tipoTransporte, tipoCombustivel, distancia, consumoCombustivel);
                habitoTransporte = tipoTransporte + " - " + distancia + " Km - Emissão CO2: " + emissaoCO2 + " Kg";
            } else {
                double consumoCombustivel = Double.parseDouble(textFieldConsumoCombustivel.getText());
                emissaoCO2 = transporte.calcularFatorEmissaoCO2Transporte(tipoTransporte, tipoCombustivel, distancia, consumoCombustivel);
                habitoTransporte = tipoTransporte + " - " + tipoCombustivel + " - " + consumoCombustivel + "L" + " - " + distancia + " Km - Emissão CO2: " + emissaoCO2 + " Kg";
            }
            listModelTransporte.addElement(habitoTransporte);
        }
    }

    private void atualizarCamposTransporte() {
        String tipoTransporte = (String) comboBoxTipoTransporte.getSelectedItem();

        if (tipoTransporte.equals("Carro de Passeio")) {
            textFieldConsumoCombustivel.setEnabled(true);
            comboBoxTipoCombustivel.setEnabled(true);
        } else {
            textFieldConsumoCombustivel.setEnabled(false);
            comboBoxTipoCombustivel.setEnabled(false);
        }
    }
    
    private JPanel createPanelUsoAgua() {
        JPanel panel = new JPanel(new BorderLayout());
        
        listModelConsumoAgua = new DefaultListModel<>();
        listConsumoAgua = new JList<>(listModelConsumoAgua);
        scrollPaneConsumoAgua = new JScrollPane(listConsumoAgua);
        
        buttonAdicionarConsumoAgua = new JButton("Adicionar");
        
        buttonAdicionarConsumoAgua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarConsumoDeAgua();
            }
        });
       
        panel.add(new JLabel("Consumo de Água:"), BorderLayout.NORTH);
        panel.add(scrollPaneConsumoAgua, BorderLayout.CENTER);
        panel.add(buttonAdicionarConsumoAgua, BorderLayout.SOUTH);

        return panel;
    }
    
    private void adicionarConsumoDeAgua() {
    	EmissaoUsoDeAgua usoAgua = new EmissaoUsoDeAgua();
    	
    	String[] tiposUsoAgua = {
    	        "Banho", "Lavar Louça", "Lavar Roupa", "Descarga", "Irrigação de Jardim"
    	    };
    	
    	JComboBox<String> comboBoxTipoUsoAgua = new JComboBox<>(tiposUsoAgua);
        JTextField textFieldQuantidadeAgua = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Tipo de Uso de Água:"));
        panel.add(comboBoxTipoUsoAgua);
        panel.add(new JLabel("Quantidade de Água (Litros):"));
        panel.add(textFieldQuantidadeAgua);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Uso de Água",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
        	
        	String tipoUsoAgua = (String) comboBoxTipoUsoAgua.getSelectedItem();
            double quantidadeAgua = Double.parseDouble(textFieldQuantidadeAgua.getText());

            double emissaoCO2 = usoAgua.calcularFatorEmissaoCO2UsoDeAgua(quantidadeAgua);

            String habitoUsoAgua = tipoUsoAgua + " - " + quantidadeAgua + " L - Emissão CO2: " + emissaoCO2 + " kg";
            listModelConsumoAgua.addElement(habitoUsoAgua);
        }
    }

    public void calcularFatorEmissaoCO2(String tipoFator, TipoTransporte tipoTransporte, TipoCombustivel tipoCombustivel, TipoEnergiaEletrica tipoEnergiaEletrica, TipoAlimento tipoAlimento) throws Exception {
        if (tipoFator.equals("usodeagua")) {
            Valor = 0.41;
        } else if (tipoFator.equals("transporte")) {
            SetFatorDeEmissaoDeCO2Transporte(tipoTransporte, tipoCombustivel);
        } else if (tipoFator.equals("energiaeletrica")) {
            SetFatorDeEmissaoDeCO2EnergiaEletrica(tipoEnergiaEletrica);
        } else if (tipoFator.equals("alimento")) {
            SetFatorDeEmissaoPorAlimento(tipoAlimento);
        } else {
            throw new Exception("Não foi possível declarar o fator de emissão para este tipo");
        }
    }

    private void SetFatorDeEmissaoDeCO2Transporte(TipoTransporte tipoTransporte, TipoCombustivel tipoCombustivel) throws Exception {
        if (tipoTransporte.IsCarroDePasseio()) {
            if (tipoCombustivel.IsGasolina())
                Valor = 2.3;
            if (tipoCombustivel.IsDisel())
                Valor = 2.7;
            if (tipoCombustivel.IsEtanol())
                Valor = 1.9;
            if (tipoCombustivel.IsEletrico())
                Valor = 0.2;
        } else if (tipoTransporte.IsOnibusUrbano()) {
            Valor = 0.68;
        } else if (tipoTransporte.IsMetroOuTrem()) {
            Valor = 0.06;
        } else {
            throw new Exception("Não foi possível declarar o fator de emissão para tipo de combustível para transporte");
        }
    }

    private void SetFatorDeEmissaoDeCO2EnergiaEletrica(TipoEnergiaEletrica tipoEnergiaEletrica) throws Exception {
        if (tipoEnergiaEletrica.IsCarvao())
            Valor = 1.5;
        else if (tipoEnergiaEletrica.IsGasNatural())
            Valor = 0.4;
        else if (tipoEnergiaEletrica.IsPetroleo())
            Valor = 0.65;
        else if (tipoEnergiaEletrica.IsNuclear())
            Valor = 0.025;
        else if (tipoEnergiaEletrica.IsHidreletrica())
            Valor = 0;
        else if (tipoEnergiaEletrica.IsEolica())
            Valor = 0;
        else if (tipoEnergiaEletrica.IsSolar())
            Valor = 0;
        else if (tipoEnergiaEletrica.IsBiomassa())
            Valor = 0.3;
        else
            throw new Exception("Não foi possível declarar o fator de emissão para tipo de energia elétrica");
    }

    private void SetFatorDeEmissaoPorAlimento(TipoAlimento tipoAlimento) throws Exception {
        if (tipoAlimento.IsCarneBovina())
            Valor = 60;
        else if (tipoAlimento.IsCarneDePorco())
            Valor = 7;
        else if (tipoAlimento.IsFrango())
            Valor = 6;
        else if (tipoAlimento.IsPeixeFresco())
            Valor = 5;
        else if (tipoAlimento.IsLeite())
            Valor = 1;
        else if (tipoAlimento.IsQueijo())
            Valor = 13.5;
        else if (tipoAlimento.IsOvos())
            Valor = 4.75;
        else if (tipoAlimento.IsArroz())
            Valor = 4;
        else if (tipoAlimento.IsTrigo())
            Valor = 1.4;
        else if (tipoAlimento.IsFeijao())
            Valor = 0.5;
        else if (tipoAlimento.IsBatatas())
            Valor = 0.2;
        else if (tipoAlimento.IsAlface())
            Valor = 0.2;
        else if (tipoAlimento.IsTomate())
            Valor = 0.3;
        else if (tipoAlimento.IsCenoura())
            Valor = 0.2;
        else if (tipoAlimento.IsMacas())
            Valor = 0.2;
        else if (tipoAlimento.IsBanana())
            Valor = 0.2;
        else if (tipoAlimento.IsChocolate())
            Valor = 17;
        else if (tipoAlimento.IsCafe())
            Valor = 16;
        else
            throw new Exception("Não foi possível declarar o fator de emissão para tipo de alimento");
    }

    public double GetValue() {
        return Valor;
    }
    
}

