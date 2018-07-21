package gob.pe.unmsm.becas.alumnos.domain.entity;

import gob.pe.unmsm.becas.alumnos.application.BecasService;
import gob.pe.unmsm.becas.alumnos.application.dto.AlumnoDto;

public class AlumnoDoctorado extends Alumno implements BecasService {

	public Double montoBecaDoctorado = 3300.00;
	private double salarioBase = 1400;
	private double tasaDoctorado = 0.06;

	public AlumnoDoctorado(AlumnoDto alumnoDto) {
		super(alumnoDto);
	}

	public AlumnoDoctorado(Alumno alumno) {
		super(alumno);
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
