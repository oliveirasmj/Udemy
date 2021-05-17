package ws;

public class Atividade {

	private Integer idActivity;
	private String nameActivity;
	private Pessoa pessoa;
	
	public Atividade(Integer idActivity, String nameActivity, Pessoa pessoa) {
		this.idActivity = idActivity;
		this.nameActivity = nameActivity;
		this.pessoa = pessoa;
	}

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Atividade [idActivity=" + idActivity + ", nameActivity=" + nameActivity + ", pessoa=" + pessoa + "]";
	}
}
