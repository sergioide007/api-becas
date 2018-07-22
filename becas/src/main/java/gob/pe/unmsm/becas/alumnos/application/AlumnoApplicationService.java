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
	
	public ResponseEntity<Object> saveAlumno(AlumnoDto alumnoDto) throws Exception {
		Alumno alumno = new Alumno();
		alumno.setFirstName(alumnoDto.getFirstName());
		alumno.setLastName(alumnoDto.getLastName());
		alumno.setActive(Constantes.ACTIVO);
		alumno.setTipoAlumno(alumnoDto.getTipoAlumno());
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
		Map<String, Object> alumno = alumnoDao.findAllByTipo(tipo, pag, pagLength);		
		if(alumno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(alumno);
	}

	public ResponseEntity<Object> getCalculoBecaByTipoAlumno(Optional<String> tipo) throws Exception {
		Map<String, Double> result = new HashMap<>();		
		Alumno alumno = new AlumnoPregrado();
		if ( Constantes.ALUMNO_MAESTRIA.equals(tipo.get()) ) {
			alumno = new AlumnoMaestria();
		} else if ( Constantes.ALUMNO_DOCTORADO.equals(tipo.get()) ) {
			alumno = new AlumnoDoctorado();
		}
		result.put("montoBeca", alumno.calcularMonto());
		return ResponseEntity.ok().body(result);
	}


}
