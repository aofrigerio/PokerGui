package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//PokerGui frame = new PokerGui();
					PokerGui frame = new PokerGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
