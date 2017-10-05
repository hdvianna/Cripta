
public class EncontraPrimos {
	private static long const_total = 10;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//const_total = Long.parseLong(args[0]);
		
		// TODO Auto-generated method stub
		ArquivoPrimo arquivoPrimo = new ArquivoPrimo("primos.txt");
		System.out.println("Carregando arquivo...");
		ConjuntoPrimos conjuntoPrimos = arquivoPrimo.carrega();
		System.out.println("Arquivo carregado.");		
		
		long proximoNumero = conjuntoPrimos.getUltimoNumero();
		Numero numero = new Numero();
		System.out.println("Numero encontrado da ultima execucao: " + conjuntoPrimos.getUltimoNumero());
		System.out.println("O sistema testara " + const_total + " numeros.");
		for (long i=0;i<const_total;i++) {			
			proximoNumero+=2;
			if (numero.ehPrimo(proximoNumero, conjuntoPrimos)) {
				conjuntoPrimos.adicionaNumero(proximoNumero);
				System.out.println("Primo encontrado. " + proximoNumero);
			}
		}
		System.out.println("Numeros testados. Salvando arquivo ...");
		arquivoPrimo.salva(conjuntoPrimos);
		System.out.println("Arquivo salvo.");
		System.out.println("Numero encontrado desta execucao: " + conjuntoPrimos.getUltimoNumero());
		System.out.println("Programa finalizado.");
			
	}

}
