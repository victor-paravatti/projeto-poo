package ifnet;

public class Professor extends Usuario{
	
	private String area;
	private Disciplina disciplMinistrada;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Disciplina getDiciplMinistrada() {
		return disciplMinistrada;
	}
	public void setDiciplMinistrada(Disciplina disciplMinistrada) {
		this.disciplMinistrada = disciplMinistrada;
	}

}
