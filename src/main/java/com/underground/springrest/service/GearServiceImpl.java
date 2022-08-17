package com.underground.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.underground.springrest.dao.GearDAO;
import com.underground.springrest.entity.Gear;

import org.springframework.stereotype.Service;


@Service
public class GearServiceImpl implements GearService {
	
	@Autowired
	private GearDAO gearDAO;
	
	@Override
	@Transactional
	public List<Gear> getGears() {
		
		return gearDAO.getGears();
	}

	@Override
	@Transactional
	public void saveGear(Gear theGear) {
		gearDAO.saveGear(theGear);
		
	}

	@Override
	@Transactional
	public Gear getGear(int theId) {
		
		return gearDAO.getGear(theId);
	}

	@Override
	@Transactional
	public void deleteGear(int theId) {
		gearDAO.deleteGear(theId);
		
	}

}
