package gob.pe.unmsm.becas.alumnos.domain.entity;

public class Alumno {

	private Long id;
	private String firstName;
	private String lastName;
	public Boolean active;
	public String tipoAlumno;
	private Double montoSinBeca = 0.0;
	
	public Alumno() {
		super();
	}

	public Alumno(Long id, String firstName, String lastName, Boolean active, String tipoAlumno) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.tipoAlumno = tipoAlumno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getTipoAlumno() {
		return tipoAlumno;
	}

	public void setTipoAlumno(String tipoAlumno) {
		this.tipoAlumno = tipoAlumno;
	}

	public Double calcularMonto() {
		return montoSinBeca;
	}
	
	
}
