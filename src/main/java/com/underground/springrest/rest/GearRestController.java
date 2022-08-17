package com.underground.springrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underground.springrest.entity.Gear;
import com.underground.springrest.service.GearService;

@RestController
@RequestMapping("/api")
public class GearRestController {
	@Autowired
	private GearService gearService;
	
	// add mapping for GET /gears
		@GetMapping("/gears")
		public List<Gear> getGears() {
			
			return gearService.getGears();
			
		}
		
		// add mapping for GET /gears/{gearId}
		
		@GetMapping("/gears/{gearId}")
		public Gear getGear(@PathVariable int gearId) {
			
			Gear theGear = gearService.getGear(gearId);
			
			if (theGear == null) {
				throw new GearNotFoundException("Gear id not found - " + gearId);
			}
			
			return theGear;
		}

		// add mapping for POST /gears  - add new gear
		
		@PostMapping("/gears")
		public Gear addGear(@RequestBody Gear theGear) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			theGear.setId(0);
			
			gearService.saveGear(theGear);
			
			return theGear;
		}
	
}
