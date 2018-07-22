package gob.pe.unmsm.becas.alumnos.domain.entity;

import gob.pe.unmsm.becas.alumnos.application.BecasService;

public class AlumnoDoctorado extends Alumno implements BecasService {

	public Double montoBecaDoctorado = 3300.00;
	private double salarioBase = 1400;
	private double tasaDoctorado = 0.06;



	public AlumnoDoctorado() {
		super();
	}

	public AlumnoDoctorado(Long id, String firstName, String lastName, Boolean active, String tipoAlumno) {
		super(id, firstName, lastName, active, tipoAlumno);
	}

	@Override
	public Double calcularMonto() {
		return salarioBase * tasaDoctorado + montoBecaDoctorado;
	}

	public Double getMontoBecaDoctorado() {
		return montoBecaDoctorado;
	}

	public void setMontoBecaDoctorado(Double montoBecaDoctorado) {
		this.montoBecaDoctorado = montoBecaDoctorado;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getTasaDoctorado() {
		return tasaDoctorado;
	}

	public void setTasaDoctorado(double tasaDoctorado) {
		this.tasaDoctorado = tasaDoctorado;
	}

}
