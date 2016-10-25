package Main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Model.MaoEnum;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;


public class PokerGui extends JFrame {

	private JPanel Gui;
	
	public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
	}
        
	public PokerGui() {
		
		//Lógica Fuzzy
		ModelPoker poker = new ModelPoker();
		LogicFuzzy fuzzy = new LogicFuzzy(poker);
		
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
				
		Gui = new JPanel();
		Gui.setToolTipText("");
		Gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Gui);
		Gui.setLayout(null);
		
		JLabel lblValorPote = new JLabel("POTE TOTAL");
		lblValorPote.setBounds(23, 329, 109, 14);
		Gui.add(lblValorPote);
		
		JFormattedTextField frmtdtxtfldValorPote = new JFormattedTextField(Mascara("####"));
		frmtdtxtfldValorPote.setBounds(23, 354, 109, 20);
		Gui.add(frmtdtxtfldValorPote);
		
		JLabel lblPokerhelp = new JLabel("PokerHelp");
		lblPokerhelp.setBounds(22, 34, 89, 14);
		Gui.add(lblPokerhelp);
		
		JLabel lblAposta = new JLabel("APOSTA");
		lblAposta.setBounds(171, 329, 109, 14);
		Gui.add(lblAposta);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(Mascara("####"));
		formattedTextField.setToolTipText("@ 11");
		formattedTextField.setBounds(171, 353, 109, 20);
		Gui.add(formattedTextField);
		
		JLabel lblMao = new JLabel("FICHAS");
		lblMao.setBounds(318, 329, 109, 14);
		Gui.add(lblMao);
		
		JLabel lblMao_1 = new JLabel("MAO");
		lblMao_1.setBounds(562, 329, 70, 14);
		Gui.add(lblMao_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(Mascara("####"));
		formattedTextField_1.setToolTipText("@ 11");
		formattedTextField_1.setBounds(318, 353, 109, 20);
		Gui.add(formattedTextField_1);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(MaoEnum.values()));
		comboBox_7.setBounds(509, 354, 171, 20);
		Gui.add(comboBox_7);
		
		JLabel lblNewLabel = new JLabel("Decis\u00E3o: ");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 45));
		lblNewLabel.setBounds(23, 141, 700, 57);
		Gui.add(lblNewLabel);
		
		JLabel label = new JLabel("Valor...");
		label.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		label.setBounds(108, 195, 194, 26);
		Gui.add(label);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//classe modelo das variáveis
				//ModelPoker poker = new ModelPoker();	
			
				MaoEnum opcao = (MaoEnum) comboBox_7.getSelectedItem(); //Retorna a opcao do menu
				
				poker.setPote(4);
				poker.setAposta(3);
				poker.setFichas(4);
				poker.setMao(opcao.getValor());
				
				//Lógica Fuzzy
				//LogicFuzzy fuzzy = new LogicFuzzy(poker);
				fuzzy.Calcular();
				fuzzy.Mostrar();
				//fuzzy.grafico();
				
				
				if(fuzzy.getDeffuzy() >= 0 & fuzzy.getDeffuzy() < 20){
					lblNewLabel.setText("Decisão: Corre (Fold)");
				}
				
				if((fuzzy.getDeffuzy() >= 20) & (fuzzy.getDeffuzy() < 40)){
					lblNewLabel.setText("Decisão: Continue (Check)");
				}
				
				if(fuzzy.getDeffuzy() > 40 & fuzzy.getDeffuzy() <= 60){
					lblNewLabel.setText("Decisão: Aumenta (Raise)");
				}
				
				label.setText("Valor: " + fuzzy.getDeffuzy());
				
				
				
				
			}
		});
		btnNewButton.setBounds(591, 395, 89, 23);
		Gui.add(btnNewButton);
		
		JButton btnInicio = new JButton("Inicio Partida");
		btnInicio.setBounds(23, 296, 109, 23);
		Gui.add(btnInicio);
		
		JButton btnFimPartida = new JButton("Fim Partida");
		btnFimPartida.setBounds(171, 295, 121, 23);
		Gui.add(btnFimPartida);
		
		JButton btnVenceu = new JButton("Venceu");
		btnVenceu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fuzzy.um();
			}
		});
		btnVenceu.setBounds(23, 395, 109, 23);
		Gui.add(btnVenceu);
		
		JButton btnPerdeu = new JButton("Perdeu");
		btnPerdeu.setBounds(318, 395, 109, 23);
		Gui.add(btnPerdeu);
		
	
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Graficos");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuzzy.grafico();
				//fuzzy.um();
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sobre");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensagem;
				
				mensagem = "Criado por Alan Oliveira Frigério \n";
				mensagem += " \n";
				mensagem += "Trabalho de Conclusão de Curso\n";
				mensagem += "Ciência da Computação - USC - 2016 \n";
				mensagem += " \n";
				mensagem += " \n";
				mensagem += "Protótipo de uma ferramenta inteligente de auxílio à tomada de decisão para pôquer.";
				mensagem += " \n";
				mensagem += " \n";
				mensagem += " Palavras chaves: Lógica Fuzzy, Pôquer, Java, JlogicFuzzy.";
				
				JOptionPane.showMessageDialog(null, mensagem);
				
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Fechar");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		
		
		
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
