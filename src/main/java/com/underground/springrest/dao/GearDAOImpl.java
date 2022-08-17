package com.underground.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.underground.springrest.entity.Gear;


@Repository
public class GearDAOImpl implements GearDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Gear> getGears() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Gear> theQuery = currentSession.createQuery("from Gear order by type", Gear.class);
		// execute query and get result list
		List<Gear> gears = theQuery.getResultList();
		// return the results	
		return gears;
	}

	@Override
	public void saveGear(Gear theGear) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theGear);
	}

	@Override
	public Gear getGear(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Gear.class, theId);
	}

	@Override
	public void deleteGear(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Gear where id=:gearId");
		theQuery.setParameter("gearId", theId);
		
		theQuery.executeUpdate();
		
	}

	

	
}
