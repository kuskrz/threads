package kus.krzysztof.threads.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import kus.krzysztof.threads.entity.Knumbers;

@Service
public class KnumbersService {
	@PersistenceContext
    private EntityManager em;
	private CriteriaBuilder cb;
	private CriteriaQuery<Knumbers> cq;
	
	private CriteriaBuilder cb() {
		if (null == cb) cb = em.getCriteriaBuilder();
		return cb;
	}
	
	private CriteriaQuery<Knumbers> cq() {
		if (null == cq) cq = cb().createQuery(Knumbers.class);
		return cq;
	}
	
	public int selectNumber(int id) {
		Root<Knumbers> number = cq.from(Knumbers.class);
		Predicate pr = cb().equal(number.get("number"), id);
		cq().where(pr);
		return em.createQuery(cq()).getFirstResult();
	}
}
