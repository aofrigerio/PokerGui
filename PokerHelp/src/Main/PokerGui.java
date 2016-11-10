package Main;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import Model.MaoEnum;
import util.SoNumeros;

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
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;


public class PokerGui extends JFrame {

	private JPanel Gui;

	public PokerGui() {
		
		//Lógica Fuzzy
		ModelPoker poker = new ModelPoker();
		LogicFuzzy fuzzy = new LogicFuzzy();
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
				
		Gui = new JPanel();
		Gui.setToolTipText("");
		Gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Gui);
		Gui.setLayout(null);
		
		//JLABEL
		JLabel lblValorPote = new JLabel("VALOR RODADA");
		lblValorPote.setBounds(157, 11, 109, 14);
		Gui.add(lblValorPote);
		
		JLabel lblPokerhelp = new JLabel("PokerHelp");
		lblPokerhelp.setIcon(new ImageIcon(".Archives/naipes.png"));
		lblPokerhelp.setBounds(22, 11, 89, 14);
		Gui.add(lblPokerhelp);
		
		JLabel lblAposta = new JLabel("APOSTA OPONENTE");
		lblAposta.setBounds(157, 192, 138, 14);
		Gui.add(lblAposta);
		
		JLabel lblMao = new JLabel("FICHAS JOGADOR");
		lblMao.setBounds(157, 258, 109, 14);
		Gui.add(lblMao);
			
		JLabel lblMao_1 = new JLabel("MAO");
		lblMao_1.setBounds(157, 370, 70, 14);
		Gui.add(lblMao_1);
		
		JLabel lblvalor = new JLabel("Valor...");
		lblvalor.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblvalor.setBounds(22, 155, 194, 26);
		Gui.add(lblvalor);
		
		JLabel lblPote = new JLabel("POTE");
		lblPote.setBounds(157, 314, 109, 14);
		Gui.add(lblPote);
		
		//JTEXT
		
		
		//JFormattedTextField txtrodada = new JFormattedTextField(Mascara("####"));
		JTextField txtrodada = new JTextField();
		txtrodada.setDocument(new SoNumeros());
		//JTextField txtrodada = new JTextField();
		txtrodada.setBounds(157, 36, 109, 20);
		txtrodada.setToolTipText("rodada");
		Gui.add(txtrodada);		
		
		
		//JFormattedTextField txtfichasoponente = new JFormattedTextField(Mascara("####"));
		JTextField txtfichasoponente = new JTextField();
		txtfichasoponente.setDocument(new SoNumeros());
		txtfichasoponente.setToolTipText("rodada");
		txtfichasoponente.setBounds(157, 95, 109, 20);
		Gui.add(txtfichasoponente);
		
		//aposta
		//JFormattedTextField txtaposta = new JFormattedTextField(Mascara("####"));
		JTextField txtaposta = new JTextField();
		txtaposta.setDocument(new SoNumeros());
		txtaposta.setToolTipText("Aposta");
		txtaposta.setBounds(157, 220, 109, 20);
		Gui.add(txtaposta);
		
		//fichas
		//JFormattedTextField txtfichas = new JFormattedTextField(Mascara("####"));
		JTextField txtfichas = new JTextField();
		txtfichas.setDocument(new SoNumeros());
		txtfichas.setToolTipText("Fichas");
		txtfichas.setBounds(157, 283, 109, 20);
		Gui.add(txtfichas);
		
		//pote
		//JFormattedTextField txtpote = new JFormattedTextField(Mascara("####"));
		JTextField txtpote = new JTextField();
		txtpote.setDocument(new SoNumeros());
		txtpote.setToolTipText("Pote");
		txtpote.setBounds(157, 339, 109, 20);
		Gui.add(txtpote);
		
		//mao
		JComboBox cmbmao = new JComboBox();
		cmbmao.setModel(new DefaultComboBoxModel(MaoEnum.values()));
		cmbmao.setBounds(157, 395, 171, 20);
		Gui.add(cmbmao);
		
		//spinners
		
		JSpinner spnpartida = new JSpinner();
		spnpartida.setBounds(56, 255, 55, 20);
		Gui.add(spnpartida);
		
		JSpinner spnrodada = new JSpinner();
		spnrodada.setBounds(56, 293, 55, 20);
		Gui.add(spnrodada);
	
		//botões		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//classe modelo das variáveis
				//ModelPoker poker = new ModelPoker();	
			
				MaoEnum opcao = (MaoEnum) cmbmao.getSelectedItem(); //Retorna a opcao do menu
			
				//Total da rodada / valor * 10 = achamos a pocentagem. melhor para modelagem
				
				
				try{
					
					poker.setPote( Double.parseDouble((String) txtpote.getText())  / Double.parseDouble((String) txtrodada.getText())*10);
					poker.setAposta(Double.parseDouble((String) txtaposta.getText()) / Double.parseDouble((String) txtfichasoponente.getText())*10);
					poker.setFichas(Double.parseDouble((String) txtfichas.getText()) / Double.parseDouble((String) txtrodada.getText())*10);
					poker.setMao(opcao.getValor());
					
					//Lógica Fuzzy
					//LogicFuzzy fuzzy = new LogicFuzzy(poker);
					fuzzy.setModelPoker(poker);
					fuzzy.Calcular();
					
					System.out.print(spnpartida.getValue() + " " + spnrodada.getValue() + " ");
					
					fuzzy.Mostrar();
					
					
					
					lblvalor.setText("Resultado... " + fuzzy.getDeffuzy());
					
				}catch(Exception e){
					//JOptionPane.showMessageDialog(null, e);
					JOptionPane.showMessageDialog(null, "Insira valores nas caixas");
				}
					
							
					
					 		
			}
		});
		btnNewButton.setBounds(22, 394, 89, 23);
		Gui.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alan\\Desktop\\Quatro-Naipes.png"));
		lblNewLabel.setBounds(22, 29, 103, 115);
		Gui.add(lblNewLabel);
		
		JButton btnRandom = new JButton("random");
		btnRandom.setBounds(22, 338, 89, 23);
		btnRandom.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				
				for (int i = 0; i < 1000 ; i++) {
					Random poterandom = new Random();
					Random apostasrandom = new Random(); 
					Random fichasrandom = new Random(); 
					Random maorandom = new Random(); 
					
					try{
						
						poker.setPote(poterandom.nextDouble()*10);
						poker.setAposta(apostasrandom.nextDouble()*10);
						poker.setFichas(fichasrandom.nextDouble()*10);
						
						int maobkp = maorandom.nextInt(8);
						
						if(maobkp==0){
							poker.setMao(1);
						}
						else{
							poker.setMao(maobkp);
						}
						
						fuzzy.setModelPoker(poker);
						fuzzy.Calcular();
						fuzzy.Mostrar();
						
						lblvalor.setText("Valor... " + fuzzy.getDeffuzy());

							
					}catch(Exception e1){
						
						JOptionPane.showMessageDialog(null, "Insira valores nas caixas");
					}
						

				}
				
				
				
			}
		});
		//Gui.add(btnRandom);
		
		JLabel lblFichasOponente = new JLabel("FICHAS OPONENTE");
		lblFichasOponente.setBounds(157, 70, 109, 14);
		Gui.add(lblFichasOponente);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtaposta.setText("0");;
				txtfichas.setText("1000");;
				txtfichasoponente.setText("1000");;
				txtpote.setText("0");;
				txtrodada.setText("1000");
			}
		});
		btnreset.setBounds(22, 220, 89, 23);
		Gui.add(btnreset);
	

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
