package Main;

import javax.swing.JOptionPane;

import net.sourceforge.jFuzzyLogic.FIS;

public class LogicFuzzy {

	private FIS fis;
	
	public LogicFuzzy(FuzzyPoker poker) {
	
	String fileName = "fcl/tipper.fcl";
	fis = FIS.load(fileName,true);
	
		if( fis == null ) { // Error while loading?
			//System.err.println("Can't load file: '" + fileName + "'");
			JOptionPane.showConfirmDialog(null, "Arquivo impossível de abrir. Verifique");
		}
	}
	/*
	public void Mostrar(){
		fis.chart();	
	}
	*/
	
	public void Calcular(){
		fis.evaluate();
	}
	
	public void SetJogadores(){
		fis.setVariable("service", 3);
		fis.setVariable("food", 7);
		
	}
	
	public void SetVlrMesa(){
		fis.setVariable("service", 3);
		fis.setVariable("food", 7);
	}

	/*
	public void Defuzificar(){
	    fis.getVariable("tip").chartDefuzzifier(true);
	}
	*/
}
