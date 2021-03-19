package diversos.imutabilidade;

import java.util.Date;

public final class ComImutabilidade2 {

	private final String linha;
	private final Date data;

    public ComImutabilidade2(String linha, Date data) {
        this.linha = linha;
        //this.data = data; //NOOOOOOOOOOO
        this.data = new Date(data.getTime()); //criar sempre instancias para objetos mutaveis
    }

    public String getLinha() {
        return linha;
    }

	public Date getData() {
		//return data; //NOOOOOOOOOOO
		return new Date(data.getTime()); //criar sempre instancias para objetos mutaveis
	}
    
    
}