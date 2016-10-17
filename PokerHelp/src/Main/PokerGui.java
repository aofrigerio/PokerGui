package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;

public class PokerGui extends JFrame {

	private JPanel Gui;

	
	public PokerGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		Gui = new JPanel();
		Gui.setToolTipText("");
		Gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Gui);
		Gui.setLayout(null);
		
		JButton btnNewButton = new JButton("Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 377, 89, 23);
		Gui.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(485, 365, 89, 23);
		Gui.add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2, 2, 8, 1));
		spinner.setBounds(145, 346, 29, 20);
		Gui.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Total Jogadores mesa");
		lblNewLabel.setBounds(10, 349, 125, 14);
		Gui.add(lblNewLabel);
		
		JLabel lblJogadoresDesistiram = new JLabel("Jogadores desistiram");
		lblJogadoresDesistiram.setBounds(10, 229, 125, 14);
		Gui.add(lblJogadoresDesistiram);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		spinner_1.setToolTipText("Jogadores em FOLD");
		spinner_1.setBounds(145, 226, 29, 20);
		Gui.add(spinner_1);
		
		JLabel lblJogadoresNoJogo = new JLabel("Jogadores no jogo");
		lblJogadoresNoJogo.setBounds(10, 267, 125, 14);
		Gui.add(lblJogadoresNoJogo);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		spinner_2.setToolTipText("Quais jogadores ainda est\u00E3o na rodada");
		spinner_2.setBounds(145, 264, 29, 20);
		Gui.add(spinner_2);
		
		JLabel lblValorPote = new JLabel("Valor pote");
		lblValorPote.setBounds(203, 229, 70, 14);
		Gui.add(lblValorPote);
		
		JFormattedTextField frmtdtxtfldValorPote = new JFormattedTextField();
		frmtdtxtfldValorPote.setToolTipText("@ 11");
		frmtdtxtfldValorPote.setBounds(283, 226, 109, 20);
		Gui.add(frmtdtxtfldValorPote);
		
		JLabel lblRaise = new JLabel("Raise");
		lblRaise.setToolTipText("Totais de aumentos na partida");
		lblRaise.setBounds(10, 306, 125, 14);
		Gui.add(lblRaise);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		spinner_3.setToolTipText("Quais jogadores ainda est\u00E3o na rodada");
		spinner_3.setBounds(145, 303, 29, 20);
		Gui.add(spinner_3);
		
		JLabel lblPokerhelp = new JLabel("PokerHelp");
		lblPokerhelp.setBounds(10, 11, 89, 14);
		Gui.add(lblPokerhelp);
		
	}
}
