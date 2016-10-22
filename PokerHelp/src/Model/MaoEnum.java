package Model;

public enum MaoEnum {

	CARTA(1), PAR(2), DOISPARES(3), TRINCA(4), SEQUENCIA(5), FLUSH(6), FULLHOUSE(7), QUADRA(8), SEQUENCIA_NAIPES(9), SEQUENCIA_REAL(10);
		
	public int valorMao;
	
	MaoEnum(int valor){
		valorMao = valor;
	}
	
	public int getValor(){
		return valorMao;
	}
	
		
}
