package gob.pe.unmsm.becas.alumnos.domain.entity;

public class AlumnoPregrado extends Alumno {

	public Double montoBecaPregrado = 2000.00;
	public static final double salarioMinimo = 750;

	public AlumnoPregrado() {
		super();
	}

	public AlumnoPregrado(Long id, String firstName, String lastName, Boolean active, String tipoAlumno) {
		super(id, firstName, lastName, active, tipoAlumno);
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
