package entities;

public class Atividade {

	private Integer idActivity;
	private String nameActivity;
	
	public Atividade(Integer idActivity, String nameActivity) {
		this.idActivity = idActivity;
		this.nameActivity = nameActivity;
	}
	
	public String getNameActivity() {
		return nameActivity;
	}
	
	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}
	
	public Integer getIdActivity() {
		return idActivity;
	}
	
	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	@Override
	public String toString() {
		return "Atividade [idActivity=" + idActivity + ", nameActivity=" + nameActivity + "]";
	}

	
}
