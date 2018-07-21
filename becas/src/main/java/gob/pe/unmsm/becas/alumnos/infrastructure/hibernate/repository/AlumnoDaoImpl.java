package gob.pe.unmsm.becas.alumnos.infrastructure.hibernate.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import gob.pe.unmsm.becas.alumnos.domain.entity.Alumno;
import gob.pe.unmsm.becas.alumnos.domain.repository.AlumnoDao;
import gob.pe.unmsm.becas.common.infrastructure.hibernate.repository.AbstractDao;
import gob.pe.unmsm.becas.common.util.PaginationHelper;

@Repository("AlumnoDao")
public class AlumnoDaoImpl extends AbstractDao<Long, Alumno> implements AlumnoDao {

    private final PaginationHelper paginationHelper = new PaginationHelper();
    protected final Log log = LogFactory.getLog(getClass());
	
	@Override
	public Alumno create(Alumno Alumno) throws Exception {
		saveOrUpdate(Alumno);
        return Alumno;
	}

	@Override
	public Alumno findById(Long id) throws Exception {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.idEq(id));
        criteria.add(Restrictions.eq("active", true));
        Alumno Alumno = (Alumno) criteria.uniqueResult();        
        return Alumno;
	}
	
	@Override
    public Map<String, Object> findAll(java.util.Optional<String> pag, java.util.Optional<String> pagLength) throws Exception {
		Criteria criteria = createEntityCriteria();
        
        criteria.setProjection(Projections.distinct(Projections.projectionList()
                .add(Projections.property("id"), "id")
        )).setResultTransformer(Transformers.aliasToBean(Alumno.class));
		Map<String, Object> result = new HashMap<String, Object>();
	    Map<String, Object> map = paginationHelper.getPagination(criteria, "id", pag, pagLength);
	
	    List<Alumno> listaAlumno = (List<Alumno>) map.get("lista");
	    result.put("listaAlumno", listaAlumno);
	    result.put("totalPage", map.get("totalPage"));
	    result.put("totalResultCount", map.get("totalResultCount"));
	
	    return result;
	}

	@Override
	public Map<String, Object> findAllByTipo(Optional<String> tipo, Optional<String> pag, Optional<String> pagLength)
			throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("active", true));
		criteria.add(Restrictions.eq("tipoAlumno", tipo.get()));
        criteria.setProjection(Projections.distinct(Projections.projectionList()
                .add(Projections.property("id"), "id")
        )).setResultTransformer(Transformers.aliasToBean(Alumno.class));
		Map<String, Object> result = new HashMap<String, Object>();
	    Map<String, Object> map = paginationHelper.getPagination(criteria, "id", pag, pagLength);
	
	    List<Alumno> listaAlumno = (List<Alumno>) map.get("lista");
	    result.put("listaAlumno", listaAlumno);
	    result.put("totalPage", map.get("totalPage"));
	    result.put("totalResultCount", map.get("totalResultCount"));
	
	    return result;
	}

}
