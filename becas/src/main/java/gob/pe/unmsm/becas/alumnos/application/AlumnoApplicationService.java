package gob.pe.unmsm.becas.alumnos.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.pe.unmsm.becas.alumnos.application.dto.AlumnoDto;
import gob.pe.unmsm.becas.alumnos.domain.entity.Alumno;
import gob.pe.unmsm.becas.alumnos.domain.entity.AlumnoDoctorado;
import gob.pe.unmsm.becas.alumnos.domain.entity.AlumnoMaestria;
import gob.pe.unmsm.becas.alumnos.domain.entity.AlumnoPregrado;
import gob.pe.unmsm.becas.alumnos.domain.repository.AlumnoDao;
import gob.pe.unmsm.becas.common.util.Constantes;

@Service()
@Transactional
public class AlumnoApplicationService {

	@Autowired
	AlumnoDao alumnoDao;
	
	public ResponseEntity<Object> saveAlumno(AlumnoDto AlumnoDto) throws Exception {
		Alumno alumno = new AlumnoPregrado(AlumnoDto);
		if ( Constantes.alumnoMaestria.equals(AlumnoDto.getTipoAlumno()) ) {
			alumno = new AlumnoMaestria(AlumnoDto);
		} else if ( Constantes.alumnoDoctorado.equals(AlumnoDto.getTipoAlumno()) ) {
			alumno = new AlumnoDoctorado(AlumnoDto);
		}		
		alumno.setFirstName(AlumnoDto.getFirstName());
		alumno.setLastName(AlumnoDto.getLastName());
		alumno.setActive(true);
		alumnoDao.create(alumno);
		return ResponseEntity.ok().body(alumno);	
	}

	public ResponseEntity<Object> getAlumnoId(long alumnoId) throws Exception {
		Alumno alumno = alumnoDao.findById(Long.valueOf(alumnoId));		
		if(alumno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(alumno);
	}
	
	public ResponseEntity<Object> getAlumnoAll(Optional<String> pag, Optional<String> pagLength) throws Exception {
		Map<String, Object> alumno = alumnoDao.findAll(pag, pagLength);		
		if(alumno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(alumno);
	}

	public ResponseEntity<Object> getAlumnoAllByTipo(Optional<String> tipo, Optional<String> pag,
			Optional<String> pagLength) throws Exception {
		Map<String, Object> Alumno = alumnoDao.findAllByTipo(tipo, pag, pagLength);		
		if(Alumno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(Alumno);
	}

	public ResponseEntity<Object> getCalculoBecaByTipoAlumno(long alumnoId, Optional<String> tipo) throws Exception {
		Map<String, Double> result = new HashMap<>();
		Alumno alumnoBuscado = alumnoDao.findById(Long.valueOf(alumnoId));		
		if(alumnoBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		Alumno alumno = new AlumnoPregrado(alumnoBuscado);
		if ( Constantes.alumnoMaestria.equals(alumnoBuscado.getTipoAlumno()) ) {
			alumno = new AlumnoMaestria(alumnoBuscado);
		} else if ( Constantes.alumnoDoctorado.equals(alumnoBuscado.getTipoAlumno()) ) {
			alumno = new AlumnoDoctorado(alumnoBuscado);
		}
		result.put("montoBeca", alumno.calcularMonto());
		return ResponseEntity.ok().body(result);
	}


}
