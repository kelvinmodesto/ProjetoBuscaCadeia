package Busca;

public class ForcaBruta extends Busca {
	
	
	public ForcaBruta() {
		super();
		
	}

	@Override
	public void buscar(String padrao) {
		for(int t=0;t<this.getTexto().size();t++){
			for(int i=0;i< this.getTexto().get(i).length();i++ ){
				for(int j=0;j<padrao.length();j++){
					int aux=0;
					if(padrao.charAt(j)==this.getTexto().get(i).charAt(aux)){
						aux++;
					}else{
						break;
					}
				}
			}
		}
	}
	//Colocar algoritmo principal do Forca Bruta aqui
	public boolean comparar(String padrao, String texto){
		boolean result=false;
		return result;
	}

}
