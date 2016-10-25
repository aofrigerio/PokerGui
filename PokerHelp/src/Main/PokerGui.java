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

	public PokerGui() {
		
		//Lógica Fuzzy
		ModelPoker poker = new ModelPoker();
		LogicFuzzy fuzzy = new LogicFuzzy();
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
				
		Gui = new JPanel();
		Gui.setToolTipText("");
		Gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Gui);
		Gui.setLayout(null);
		
		//JLABEL
		JLabel lblValorPote = new JLabel("VALOR RODADA");
		lblValorPote.setBounds(23, 329, 109, 14);
		Gui.add(lblValorPote);
		
		JLabel lblPokerhelp = new JLabel("PokerHelp");
		lblPokerhelp.setBounds(22, 34, 89, 14);
		Gui.add(lblPokerhelp);
		
		JLabel lblAposta = new JLabel("APOSTA");
		lblAposta.setBounds(171, 329, 109, 14);
		Gui.add(lblAposta);
		
		JLabel lblMao = new JLabel("FICHAS");
		lblMao.setBounds(318, 329, 109, 14);
		Gui.add(lblMao);
			
		JLabel lblMao_1 = new JLabel("MAO");
		lblMao_1.setBounds(643, 329, 70, 14);
		Gui.add(lblMao_1);
		
		JLabel lblNewLabel = new JLabel("Decis\u00E3o: ");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 45));
		lblNewLabel.setBounds(23, 141, 700, 57);
		Gui.add(lblNewLabel);
		
		JLabel label = new JLabel("Valor...");
		label.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		label.setBounds(108, 195, 194, 26);
		Gui.add(label);
		
		JLabel lblPote = new JLabel("POTE");
		lblPote.setBounds(450, 330, 109, 14);
		Gui.add(lblPote);
		
		//JTEXT
		
		//rodada
		JFormattedTextField txtrodada = new JFormattedTextField(Mascara("####"));
		txtrodada.setBounds(23, 354, 109, 20);
		txtrodada.setToolTipText("rodada");
		Gui.add(txtrodada);
		
		//aposta
		JFormattedTextField txtaposta = new JFormattedTextField(Mascara("####"));
		txtaposta.setToolTipText("Aposta");
		txtaposta.setBounds(171, 353, 109, 20);
		Gui.add(txtaposta);
		
		//fichas
		JFormattedTextField txtfichas = new JFormattedTextField(Mascara("####"));
		txtfichas.setToolTipText("Fichas");
		txtfichas.setBounds(318, 353, 109, 20);
		Gui.add(txtfichas);
		
		//pote
		JFormattedTextField txtpote = new JFormattedTextField(Mascara("####"));
		txtpote.setToolTipText("Pote");
		txtpote.setBounds(450, 354, 109, 20);
		Gui.add(txtpote);
		
		//mao
		JComboBox cmbmao = new JComboBox();
		cmbmao.setModel(new DefaultComboBoxModel(MaoEnum.values()));
		cmbmao.setBounds(585, 354, 171, 20);
		Gui.add(cmbmao);
		
	
		//botões		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//classe modelo das variáveis
				//ModelPoker poker = new ModelPoker();	
			
				MaoEnum opcao = (MaoEnum) cmbmao.getSelectedItem(); //Retorna a opcao do menu
			
				
				//JOptionPane.showMessageDialog(null, Double.parseDouble((String) txtpote.getValue())  / Double.parseDouble((String) txtrodada.getValue() ));
				//JOptionPane.showMessageDialog(null, txtrodada.getValue());
				//JOptionPane.showMessageDialog(null, txtaposta.getValue());
				//JOptionPane.showMessageDialog(null, txtfichas.getValue());
				
				//Total da rodada / valor * 100 = achamos a pocentagem. melhor para modelagem
				
				
				try{
					
					poker.setPote( Double.parseDouble((String) txtpote.getValue())  / Double.parseDouble((String) txtrodada.getValue() ) * 10);
					poker.setAposta(Double.parseDouble((String) txtaposta.getValue()) / Double.parseDouble((String) txtrodada.getValue())* 10);
					poker.setFichas(Double.parseDouble((String) txtfichas.getValue()) / Double.parseDouble((String) txtrodada.getValue())* 10);
					poker.setMao(opcao.getValor());
					
				}catch(NumberFormatException e){
					//JOptionPane.showMessageDialog(null, e);
					JOptionPane.showMessageDialog(null, "Insira valores nas caixas");
				}
					
					//Lógica Fuzzy
					//LogicFuzzy fuzzy = new LogicFuzzy(poker);
					fuzzy.setModelPoker(poker);
					fuzzy.Calcular();
					fuzzy.Mostrar();
					
					
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
		btnNewButton.setBounds(667, 395, 89, 23);
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
