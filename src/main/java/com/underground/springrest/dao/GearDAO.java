package com.underground.springrest.dao;

import java.util.List;

import com.underground.springrest.entity.Gear;




public interface GearDAO {

	public List<Gear> getGears();
	
	public void saveGear(Gear theGear);

	public Gear getGear(int theId);
	
	public void deleteGear(int theId);
		
}
