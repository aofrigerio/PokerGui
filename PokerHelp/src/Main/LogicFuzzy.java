package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.xml.soap.Text;

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
		
		fis.setVariable("APOSTA", poker.getAposta());	//aposta
		fis.setVariable("FICHAS", poker.getFichas());	//fichas
		fis.setVariable("MAO", poker.getMao());	//mao
		fis.setVariable("POTE", poker.getPote());	//pote
	}
	
	public void Mostrar(){
		
		Locale l = new Locale("pt","BR");
		NumberFormat nf = NumberFormat.getInstance(l);
		
		System.out.println(nf.format(fis.getVariable("POTE").getValue()) +"|"
				+nf.format(fis.getVariable("APOSTA").getValue())+"|"
				+nf.format(fis.getVariable("FICHAS").getValue())+"|"
				+nf.format(fis.getVariable("MAO").getValue())+"|"
				+nf.format(fis.getVariable("ACAO").getValue())
			);
	}
	
	public void grafico(){
		
		JDialogFis fis = new JDialogFis(this.fis);
	
	}
	
	
	
	public FIS getFis(){
		return fis;
	}
	
	public double getDeffuzy(){
		return fis.getVariable("ACAO").getValue();
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
