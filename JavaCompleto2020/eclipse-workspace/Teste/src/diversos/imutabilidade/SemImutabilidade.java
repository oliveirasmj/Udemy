package diversos.imutabilidade;

public final class SemImutabilidade {

	private String linha;
	
	public SemImutabilidade(String linha) {
		this.linha = linha;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}
}
