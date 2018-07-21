package gob.pe.unmsm.becas.alumnos.infrastructure.hibernate.repository;

import org.springframework.stereotype.Repository;

import gob.pe.unmsm.becas.alumnos.domain.entity.Alumno;
import gob.pe.unmsm.becas.alumnos.domain.repository.AlumnoRepository;
import gob.pe.unmsm.becas.common.infrastructure.hibernate.repository.BaseHibernateRepository;

@Repository
public class AlumnoHibernateRepository extends BaseHibernateRepository<Alumno> implements AlumnoRepository {

}