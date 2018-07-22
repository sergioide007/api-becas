package gob.pe.unmsm.becas.alumnos.domain.entity;

public class AlumnoMaestria extends Alumno {

	public Double montoBecaMaestria = 2500.00;
	private double salarioBase = 1200;
	private double tasaMaestria = 0.05;


	
	public AlumnoMaestria() {
		super();
	}

	public AlumnoMaestria(Long id, String firstName, String lastName, Boolean active, String tipoAlumno) {
		super(id, firstName, lastName, active, tipoAlumno);
	}

	@Override
	public Double calcularMonto() {
		return salarioBase * tasaMaestria + montoBecaMaestria;
	}

	public Double getMontoBecaMaestria() {
		return montoBecaMaestria;
	}

	public void setMontoBecaMaestria(Double montoBecaMaestria) {
		this.montoBecaMaestria = montoBecaMaestria;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getTasaMaestria() {
		return tasaMaestria;
	}

	public void setTasaMaestria(double tasaMaestria) {
		this.tasaMaestria = tasaMaestria;
	}

}
