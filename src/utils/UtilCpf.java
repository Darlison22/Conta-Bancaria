package utils;

public class UtilCpf {
	
	public static boolean verificarQuantidadeDigitos(String cpf) {
		return cpf.length() == 11; 
		/*Se o resultado retornado for verdadeiro significa que o cpf passado contem 11 digitos
		 * Caso o retulado seja falso, então não foi passado um cpf valido e será gerado uma excessão
		 * */
	}
	
	public static boolean verificarApenasNumeros(String cpf) {
		
		return cpf.matches("\\d+");
		/*Se o resultado for verdadeiro, então signica que o cpf passado contem apenas numeros 
		 * Caso o resultado seja falso, então o cpf passado não possui apenas numeros e será gerado uma 
		 * excessão para tratar
		 * */
	}
	
	

}
