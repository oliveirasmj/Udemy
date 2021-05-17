package ws;

import java.util.ArrayList;
import java.util.List;

public class Atividades {
	
	private List<Atividade> atividades = new ArrayList<Atividade>();

	public Atividades() {
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	@Override
	public String toString() {
		return "Atividades [atividades=" + atividades + "]";
	}
	
	public void addActivity(Atividade a) {
		atividades.add(a);
	}
}
