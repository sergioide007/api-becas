package gob.pe.unmsm.becas.alumnos.domain.entity;

import gob.pe.unmsm.becas.alumnos.application.dto.AlumnoDto;

public class AlumnoPregrado extends Alumno {

	public Double montoBecaPregrado = 2000.00;
	public static final double salarioMinimo = 750;

	public AlumnoPregrado(AlumnoDto alumnoDto) {
		super(alumnoDto);
	}

	public AlumnoPregrado(Alumno alumno) {
		super(alumno);
	}
	
	@Override
	public Double calcularMonto() {
		if (montoBecaPregrado > salarioMinimo) {
			return montoBecaPregrado;
		} else {
			return salarioMinimo;
		}
	}

	public Double getMontoBecaPregrado() {
		return montoBecaPregrado;
	}

	public void setMontoBecaPregrado(Double montoBecaPregrado) {
		this.montoBecaPregrado = montoBecaPregrado;
	}

	public static double getSalariominimo() {
		return salarioMinimo;
	}

}
