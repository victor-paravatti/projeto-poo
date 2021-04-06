package ifnet;

public class Professor extends Usuario{
	
	private Area area;
	private Disciplina disciplMinistrada;
	
	public Professor(String nome, String prontuario, Area area, Disciplina disciplMinistrada) {
		super(nome, prontuario);
		this.area = area;
		this.disciplMinistrada = disciplMinistrada;
	}
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Disciplina getDiciplMinistrada() {
		return disciplMinistrada;
	}
	public void setDiciplMinistrada(Disciplina disciplMinistrada) {
		this.disciplMinistrada = disciplMinistrada;
	}

}
