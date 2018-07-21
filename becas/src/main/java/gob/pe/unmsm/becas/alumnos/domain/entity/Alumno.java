package gob.pe.unmsm.becas.alumnos.domain.entity;

import gob.pe.unmsm.becas.alumnos.application.dto.AlumnoDto;

public class Alumno {

	private String id;
	private String firstName;
	private String lastName;
	public Boolean active;
	public String tipoAlumno;
	private Double montoSinBeca = 0.0;
	
	public Alumno() {
		super();
	}

	public Alumno(String id, String firstName, String lastName, Boolean active, String tipoAlumno) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.tipoAlumno = tipoAlumno;
	}
	
	public Alumno(AlumnoDto alumnoDto) {
		this.id = alumnoDto.getId();
		this.firstName = alumnoDto.getFirstName();
		this.lastName = alumnoDto.getLastName();		
		this.tipoAlumno = alumnoDto.getTipoAlumno();		
	}

	public Alumno(Alumno alumno) {
		this.id = alumno.getId();
		this.firstName = alumno.getFirstName();
		this.lastName = alumno.getLastName();		
		this.tipoAlumno = alumno.getTipoAlumno();
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
