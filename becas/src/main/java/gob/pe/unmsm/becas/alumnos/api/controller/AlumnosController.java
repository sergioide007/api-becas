package gob.pe.unmsm.becas.alumnos.api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gob.pe.unmsm.becas.alumnos.application.AlumnoApplicationService;
import gob.pe.unmsm.becas.alumnos.application.dto.AlumnoDto;
import gob.pe.unmsm.becas.common.api.controller.ResponseHandler;

@RestController
@RequestMapping("api/alumnos/")
public class AlumnosController {
	
	@Autowired
	AlumnoApplicationService alumnoApplicationService;
	
	
	@Autowired
	ResponseHandler responseHandler;		
			
				
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, path = "save", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> saveCustomer(@Valid @RequestBody AlumnoDto alumnoDto) throws Exception {
		try {
		return alumnoApplicationService.saveAlumno(alumnoDto);  			
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	@CrossOrigin(origins = "*")			
	@RequestMapping(method = RequestMethod.GET, value = "/alumno/{alumnoId}")
	public ResponseEntity<Object> getalumnoId(@PathVariable(value="alumnoId") long alumnoId){
	try {				
			return alumnoApplicationService.getAlumnoId(alumnoId);				
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	
	@CrossOrigin(origins = "*")			
	@RequestMapping(method = RequestMethod.GET, value = "/alumnoAll/pag/{pag}/pagLength/{pagLength}")
	public ResponseEntity<Object> getAlumnoAll(@PathVariable(value="pag") Optional<String> pag, @PathVariable(value="pagLength") Optional<String> pagLength){
	try {	
			return alumnoApplicationService.getAlumnoAll(pag, pagLength);				
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	@CrossOrigin(origins = "*")			
	@RequestMapping(method = RequestMethod.GET, value = "/alumnoAllByTipo/tipo/{tipo}/pag/{pag}/pagLength/{pagLength}")
	public ResponseEntity<Object> getAlumnoAllByTipo(@PathVariable(value="tipo") Optional<String> tipo, @PathVariable(value="pag") Optional<String> pag, @PathVariable(value="pagLength") Optional<String> pagLength){
	try {	
			return alumnoApplicationService.getAlumnoAllByTipo(tipo, pag, pagLength);				
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	@CrossOrigin(origins = "*")			
	@RequestMapping(method = RequestMethod.GET, value = "/calculoBecaByTipoAlumno/tipo/{tipo}")
	public ResponseEntity<Object> getCalculoBecaByTipoAlumno(@PathVariable(value="tipo") Optional<String> tipo){
	try {	
			return alumnoApplicationService.getCalculoBecaByTipoAlumno(tipo);
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}

	
}
