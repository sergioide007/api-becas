package gob.pe.unmsm.becas.alumnos.domain.repository;

import java.util.Map;
import java.util.Optional;

import gob.pe.unmsm.becas.alumnos.domain.entity.Alumno;

public interface AlumnoDao {

	public Alumno create(Alumno Alumno) throws Exception;
	public Alumno findById(Long id) throws Exception;
    public Map<String, Object> findAll(java.util.Optional<String> pag, java.util.Optional<String> pagLength) throws Exception;
	public Map<String, Object> findAllByTipo(Optional<String> tipo, Optional<String> pag, Optional<String> pagLength) throws Exception;
}
