package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChartImpl;
import net.sourceforge.jFuzzyLogic.plot.JPanelFis;
import net.sourceforge.jFuzzyLogic.plot.PlotWindow;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class LogicFuzzy {
	
	ModelPoker poker;
	private FIS fis;
	int plotHeight, plotWidth; // Each plot's size 
	int posx = 0, posy = 0; // Position each plot within the panel	
	
	public LogicFuzzy() {
		
	String fileName = "./Archives/poker.flc";
	
	fis = FIS.load(fileName,true);
	
		if( fis == null ) { // Error while loading?
			JOptionPane.showConfirmDialog(null, "Arquivo impossível de abrir. Verifique");
		}
		
}
	
	
	public void Calcular(){
		
		try{
			fis.evaluate();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

	
	}
	
	public void setModelPoker(ModelPoker pk1){
		this.poker = pk1;
		
		fis.setVariable("pote", poker.getAposta());	//aposta
		fis.setVariable("aposta", poker.getFichas());	//fichas
		fis.setVariable("fichas", poker.getMao());	//mao
		fis.setVariable("mao", poker.getPote());	//pote
	}
	
	public void Mostrar(){
		System.out.println("POTE: " + fis.getVariable("pote").getValue());
		System.out.println("APOSTA: " + fis.getVariable("aposta").getValue());
		System.out.println("FICHAS: " + fis.getVariable("fichas").getValue());
		System.out.println("MAO: " + fis.getVariable("mao").getValue());
		//System.out.println("ACAO: " + fis.getVariable("acao").getLinguisticTerms());
		System.out.println("ACAO: " + fis.getVariable("acao").getValue());
			
	}
	
	public void grafico(){
		
		JDialogFis fis = new JDialogFis(this.fis);
		
	}
	
	public FIS getFis(){
		return fis;
	}
	
	public double getDeffuzy(){
		return fis.getVariable("acao").getValue();
	}
	

	public void um(){
		
		/*
		Graphics g = null;
		Rectangle2D rect = new Rectangle2D.Double();	
		FunctionBlock fb = new FunctionBlock(fis);
		fb.getVariable("acao");	
		Variable var = fb.getVariable("acao");		
		JFuzzyChart.get().draw((Graphics2D) g, rect, var);
		*/
		//teste
//		Graphics g = null;
		Rectangle2D rect = new Rectangle2D.Double();	
		FunctionBlock fb = new FunctionBlock(fis);
		//fb.variablesSorted();	
		Variable var = new Variable("acao");	
		//JFuzzyChart.get().draw((Graphics2D) g, rect, var);
		
//		JFuzzyChart.get().chart(var, true);
//		JFuzzyChartImpl.get().chart(var, dev , true);;

		
	}

	
}
